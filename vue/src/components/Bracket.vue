<template>
  <div>
      <h3>Bracket</h3>
      <p v-if="matches.length == 0">Schedule TBD</p>
      <router-link v-bind:to="{name: 'manage-bracket', params: {id: this.tournamentID, matches: this.matches, tournamentID: this.tournamentID}}"> <button v-if="this.$store.state.user.role == 'ROLE_HOST' && matches.length > 0">Edit Bracket</button></router-link>
      <button v-if="this.$store.state.user.role == 'ROLE_HOST' && matches.length == 0" v-on:click.prevent="generateBracket()">Generate Matches</button>
      <table id="schedule" v-if="matches.length > 0">
          <tr>
              <th>Round</th>
             <th>Home Team</th>
             <th>Away Team</th>
             <th>Location</th>
             <th>Start Date</th>
             <th>Start Time</th>
             <th>Winner</th>
         </tr>
         <tr v-for="match in sortedByMatchId(matches)" v-bind:key="match.matchId">
             <td>{{match.roundNumber}}</td>
            <td>{{getTeamNameFromTeamList(match.homeTeamId)}}</td>
            <td>{{getTeamNameFromTeamList(match.awayTeamId)}}</td>
            <td>{{match.locationId}}</td>
            <td>{{match.startDate}}</td>
            <td>{{match.startTime}}</td>
            <td>{{getTeamNameFromTeamList(match.winningTeamId) ? match.winningTeamName : "TBD"}}</td>
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
                        this.$router.push({name: "manage-bracket", params: {id: this.tournamentID, matches: response.data, tournamentID: this.tournamentID}});
                    }
            });
        },
        // need some more complex logic here to display differently if bye or tbd
        getTeamNameFromTeamList(teamId) {
            console.log(teamId)
            const activeTeam = this.tournamentTeams.find((team) => {
                if (team.teamId == teamId) {
                    return true;
                }
            });
            console.log(activeTeam)
            if (activeTeam) {
                return activeTeam.teamName;
            }
            return '';
        },
        compareMatchId(match1, match2) {
            if (match1.matchId > match2.matchId) {
                return 1;
            }
            if (match1.matchId < match2.matchId) {
                return -1;
            }
            return 0;
        },
        sortedByMatchId (arr) {
            return arr.sort(this.compareMatchId);
        }
    },
    created () {
        console.log('teams: ' + this.tournamentTeams);
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
        
    },
    data () {
        return {
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
            matches: []
        }
    }
}
</script>

<style>
    img {
        width: 500px;
    }
</style>