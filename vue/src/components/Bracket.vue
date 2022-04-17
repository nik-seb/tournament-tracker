<template>
  <div>
      <h3>Bracket</h3>
      <p v-if="matches.length == 0">Schedule TBD</p>
      <button v-if="this.$store.state.user.role == 'ROLE_HOST'" v-on:click.prevent="generateBracket()">Generate Matches</button>
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
            <td>{{match.homeTeamName}}</td>
            <td>{{match.awayTeamName}}</td>
            <td>{{match.locationId}}</td>
            <td>{{match.startDate}}</td>
            <td>{{match.startTime}}</td>
            <td>{{(match.winningTeamName) ? match.winningTeamName : "TBD"}}</td>
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
        }
    },
    created () {
        // get matches and fill matches array with data, then:
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
                }
            ],
            matches: [
                {
                    matchId: 1,
                    tournamentId: 1,
                    startDate: '2022-02-01',
                    startTime: '12:10:00',
                    homeTeamId: 1,
                    awayTeamId: 2,
                    locationId: 1,
                    winningTeamId: 2,
                    roundNumber: 1
                },
                {
                    matchId: 2,
                    tournamentId: 1,
                    startDate: '2022-02-03',
                    startTime: '08:00:00',
                    homeTeamId: 5,
                    awayTeamId: 8,
                    locationId: 2,
                    winningTeamId: null,
                    roundNumber: 1
                }
            ]
        }
    }
}
</script>

<style>
    img {
        width: 500px;
    }
</style>