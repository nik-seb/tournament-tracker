<template>
  <div>
      <h3>Bracket</h3>
      <p v-if="matches.length == 0">Schedule TBD</p>
      <router-link v-bind:to="{name: 'manage-bracket', params: {id: this.tournamentID, matches: this.matches, tournamentID: this.tournamentID}}"> <button v-if="isHost && matches.length > 0">Edit Bracket</button></router-link>
      <button v-if="isHost && matches.length == 0" v-on:click.prevent="generateBracket()">Generate Matches</button>
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
        }
    },
    computed: {
        sortedByStartDate() {
            return this.matches.slice().sort(this.compareDate);
        }
    },
    created () {
        TournamentService.getMatchesByTournamentId(this.tournamentID).then((response) => {
                if (response.status == 200) {
                    this.matches = response.data;
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
            tournament: {
                name: 'Cool tournament',
                startDate: '1990-04-05',
                endDate: '1999-08-09',
                sportId: '5',
                numOfTeams: '99',   
                id: 1
            },
            teams: [
                {
                    teamId: 1,
                    teamName: 'Owls'
                },
                {
                    teamId: 2,
                    teamName: 'Eagles'
                },
                {
                    teamId: 3,
                    teamName: 'Falcons'
                },
                {
                    teamId: 4,
                    teamName: 'Larks'
                },
                {
                    teamId: 5,
                    teamName: 'Toucans'
                },
                {
                    teamId: 6,
                    teamName: 'Finches'
                },
                {
                    teamId: 7,
                    teamName: 'Blackbirds'
                },
                {
                    teamId: 13,
                    teamName: 'BYE'
                }
            ],
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