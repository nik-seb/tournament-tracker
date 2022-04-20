<template>
  <div>
      <h3>Bracket</h3>
      <p v-if="matches.length == 0">Schedule TBD</p>
      <router-link v-bind:to="{name: 'manage-bracket', params: {id: this.tournamentID, matches: this.matches, tournamentID: this.tournamentID}}"> <button v-if="isHost && matches.length > 0">Edit Bracket</button></router-link>
      <button v-if="isHost && matches.length == 0" v-on:click.prevent="generateBracket()">Generate Matches</button>
      <button v-if="isHost && canGenerateNextRound">Generate Matches for Next Round</button>
      <table id="schedule" v-if="matches.length > 0">
          <tr>
              <th>Round</th>
             <th>Home Team</th>
             <th>Away Team</th>
             <th>Location</th>
             <th>Start Date</th>
             <th>Start Time</th>
             <th>Winner</th>
             <th></th>
         </tr>
         <tr v-for="match in sortedByStartDate" v-bind:key="match.matchId">
             <td>{{match.roundNumber}}</td>
            <td>{{getTeamNameFromTeamList(match.homeTeamId)}}</td>
            <td>{{getTeamNameFromTeamList(match.awayTeamId)}}</td>
            <td>{{getLocationNameFromLocationList(match.locationId)}}</td>
            <td>{{match.startDate}}</td>
            <td>{{match.startTime}}</td>
            <td>{{getTeamNameFromTeamList(match.winningTeamId) || "TBD"}}</td>
            <td><button v-on:click="addWinner(match)" v-if="match.winningTeamId == 0">Add Winner</button></td>
        </tr>
      </table>
  </div>
</template>

<script>
import TournamentService from "@/services/TournamentService.js";
export default {
    name: 'bracket',
    props: {
        tournamentID: Number
    },
    methods: {
        generateBracket() {
            TournamentService.createBracketForTournament(this.tournamentID).then((response) => {
                if (response.status == 200) {
                        this.$router.push({name: "manage-bracket", params: {id: this.tournamentID, matches: response.data, tournamentID: this.tournamentID, teams: this.tournamentTeams}});
                    }
            });
        },
        // need some more complex logic here to display differently if bye or tbd
        getTeamNameFromTeamList(teamId) {
            const activeTeam = this.tournamentTeams.find((team) => {
                if (team.teamId == teamId) {
                    return true;
                }
            });
            if (activeTeam) {
                return activeTeam.teamName;
            }
            return '';
        },
        getLocationNameFromLocationList(locationId) {
            const activeLocation = this.locations.find((location) => {
                if (location.locationId == locationId) {
                    return true;
                }
            })
            if (activeLocation) {
                return `${activeLocation.cityName}, ${activeLocation.stateName}`
            }
            return locationId;
        },
        compareDate(match1, match2) {
            // checks regular dates first, then date + time if dates are equal
            if (match1.startDate == null) {
                return +1;
            }
            if (match1.startDate.toString() > match2.startDate.toString()) {
                return 1;
            } else if (match1.startDate.toString() < match2.startDate.toString()) {
                return -1;
            }
            if (match1.startTime == null) {
                return +1;
            } else if ((match1.startDate.toString() + match1.startTime.toString()) > (match2.startDate.toString() + match2.startTime.toString())) {
                return 1;
            } else if ((match1.startDate.toString() + match1.startTime.toString()) < (match2.startDate.toString() + match2.startTime.toString())) {
                return -1;
            }
            return 0;
        },
        addWinner(currentMatch) {
            this.$router.push({name: 'winner-form', params: {id: currentMatch.matchId}})
        },
        // check for the most recent round where num of matches = num of winners declared, and set to 0 if no rounds completed
        // then check if a match in the round after that has a bye, and if so, next round must be generated
        checkCompletedRounds() {
            let recordMatches = {}; // number of matches per round
            let recordWins = {}; // number of wins per round
            let validRounds = []; // number of rounds in this set of matches
            for (let match of this.matches) {
                if (recordMatches[match.roundNumber] >= 1) {
                    recordMatches[match.roundNumber]++;
                } else {
                    recordMatches[match.roundNumber] = 1;
                    validRounds.push(match.roundNumber)
                }
                if (recordWins[match.roundNumber] >= 1 && match.winningTeamId != 0) {
                    recordWins[match.roundNumber]++;
                } else if (match.winningTeamId != 0) {
                    recordWins[match.roundNumber] = 1;
                } else if (match.winningTeamId == 0) {
                    recordWins[match.roundNumber] = 0;
                }
            }
            let mostRecentlyCompleted = 0;
            for (let round in validRounds) {
                if (recordMatches[round] == recordWins[round]) {
                    mostRecentlyCompleted = Number(round);
                } 
            }
            let readyForNextRound = false;

            if (mostRecentlyCompleted == 0) {
                return readyForNextRound;
            }

            // if any match of round after 1 has bye, that round hasn't had matches generated yet
            for (let match of this.matches) {
                if (match.roundNumber == mostRecentlyCompleted+1) {
                    if (match.homeTeamId == 13 || match.awayTeamId == 13) {
                        readyForNextRound = true;
                        break;
                    }
                }
            }
            return readyForNextRound;
        }
    },
    computed: {
        sortedByStartDate() {
            return this.matches.slice().sort(this.compareDate);
        },
        canGenerateNextRound() {
            return this.checkCompletedRounds();
        }
    },
    created () {
        TournamentService.getMatchesByTournamentId(this.tournamentID).then((response) => {
                if (response.status == 200) {
                    this.matches = response.data;
                            console.log(this.checkCompletedRounds())
                    TournamentService.getParticipantsInTournament(this.$route.params.id).then(response => {
                        if (response.status == 200) {
                            this.tournamentTeams = response.data;
                        }
                    })            
                }
            });
        TournamentService.getAllLocations().then((response) => {
                if (response.status == 200) {
                    this.locations = response.data;            
                }
            })
    },
    data () {
        return {
            isHost: this.$store.state.user.role == 'ROLE_HOST',
            winnerForm: false,
            tournamentTeams: [],
            matches: [],
            locations: []
        }
    }
}
</script>

<style>
    img {
        width: 500px;
    }
</style>