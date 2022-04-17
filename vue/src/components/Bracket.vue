<template>
  <div>
      <h3>Bracket</h3>
      <p v-if="matches.length == 0">Schedule TBD</p>
      <button v-if="this.$store.state.user.role == 'ROLE_HOST' && matches.length == 0" v-on:click.prevent="generateBracket()">Generate Matches</button>
      <table id="schedule" v-if="matches.length > 0">
          <tr>
             <th>Home Team</th>
             <th>Away Team</th>
             <th>Location</th>
             <th>Start Date</th>
             <th>Start Time</th>
             <th>Winner</th>
         </tr>
         <tr v-for="match in matches" v-bind:key="match.matchId">
            <td>{{getTeamNameFromTeamList(match.homeTeamId)}}</td>
            <td>{{getTeamNameFromTeamList(match.awayTeamId)}}</td>
            <td>{{match.locationId}}</td>
            <td>{{match.startDate}}</td>
            <td>{{match.startTime}}</td>
            <td>{{(match.winningTeamName) ? match.winningTeamName : "TBD"}}</td>
            <!-- <td v-for="team in tournamentTeams" v-bind:key="team.teamId">{{team.teamName}}></td> -->
            <!-- THIS THING WORKS FINE WITH TOURNAMENT TEAMS^^^^^^ -->
        </tr>
      </table>
  </div>
</template>

<script>
import TournamentService from "@/services/TournamentService.js";
export default {
    name: 'bracket',
    props: {
        tournamentID: Number,
        tournamentTeams: Array
    },
    methods: {
        generateBracket() {
            TournamentService.createBracketForTournament(this.tournamentID).then((response) => {
                if (response.status == 200) {
                        this.$router.push({name: "manage-bracket", params: {id: this.tournamentID, matches: response.data, tournamentID: this.tournamentID}});
                    }
            });
        },
        // THIS BREAKS IF I GIVE IT TOURNAMENT TEAMS 
        // need some more complex logic here to display differently if bye or tbd
        getTeamNameFromTeamList(teamId) {
            console.log(teamId)
            const activeTeam = this.teams.find((team) => {
                if (team.teamId == teamId) {
                    return true;
                }
            });
            console.log(activeTeam)
            return activeTeam.teamName;
        }
    },
    created () {
        TournamentService.getMatchesByTournamentId(this.tournamentID).then((response) => {
                if (response.status == 200) {
                    this.matches = response.data;
                    if (this.matches.length > 0) {
                        for (let match of this.matches) {
                            TournamentService.getTeamByTeamId(match.homeTeamId).then((response) => {
                                if (response.status == 200) {
                                    match.homeTeamName = response.data.teamName;
                                }
                            })
                            TournamentService.getTeamByTeamId(match.awayTeamId).then((response) => {
                                if (response.status == 200) {
                                    match.awayTeamName = response.data.teamName;
                                } 
                            })
                            if (match.winningTeamId) {
                                TournamentService.getTeamByTeamId(match.winningTeamId).then((response) => {
                                if (response.status == 200) {
                                    match.winningTeamName = response.data.teamName;
                                }
                            })
                            }
                            // add get for location name when that model/method is available
                        }
                    }
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