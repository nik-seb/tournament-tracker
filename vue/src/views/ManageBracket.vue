<template>
    <div>
        <h2> Edit the matches for this bracket</h2>
        <p>Each match can only be edited until its winner is set.</p>
        <edit-match-form v-for="match in matchesList" v-bind:key="match.matchId" v-bind:Match="match"/>
        <router-link v-bind:to="{name: 'view-tournament', params: {id: this.tournamentID}}"><button>Return to tournament page</button></router-link>
    </div>
</template>

<script>
import EditMatchForm from '@/components/EditMatchForm.vue'
import TournamentService from '@/services/TournamentService.js'
import HolidayService from '@/services/HolidayService.js'
export default {
    name: 'manage-bracket',
    props: {
        tournamentID: Number,
        matches: Array
    },
    components: {
        EditMatchForm
    },
    created () {
        console.log(this.matches)
        this.matchesList = this.matches;
        if (!this.matchesList || this.matchesList.length == 0) {
            TournamentService.getMatchesByTournamentId(this.tournamentID).then((response) => {
                if (response.status == 200) {
                    this.matchesList = response.data;
                    TournamentService.getParticipantsInTournament(this.tournamentID).then(response => {
                        console.log(response.data)
                        if (response.status == 200) {
                            this.teams = response.data;
                            this.updateMatchesWithNames();
                    }
                 })
                }
            })
        } else {
            TournamentService.getParticipantsInTournament(this.tournamentID).then(response => {
                        console.log(response.data)
                        if (response.status == 200) {
                            this.teams = response.data;
                            this.updateMatchesWithNames();
                    }
                 })
        }

        if (!this.$store.state.holidays || this.$store.state.holidays.length == 0) {
            HolidayService.getAllHolidays().then(response => {
                if (response.status == 200) {
                    this.$store.commit("SET_HOLIDAYS", response.data)
                }
            })
        }
         
    },
    data () {
        return {
            matchesList: [],
            namedMatchesList: [],
            teams: []
        }
    },
    methods: {
        updateMatchesWithNames () {
            //BELOW mutates matches list even though it's map? I iterate through matcheslist and it still receives the names
            // this.namedMatches = this.matchesList.map((match) => {
            //     let team1 = this.teams.find((team) => {
            //         if (team.teamId == match.homeTeamId) {
            //             return true;
            //         }
            //     });
            //     if (team1) {
            //         match.homeTeamName = team1.teamName;
            //     } else {
            //         match.homeTeamName = '';
            //     }
            //     let team2 = this.teams.find((team) => {
            //         if (team.teamId == match.awayTeamId) {
            //             return true;
            //         }
            //     })
            //     if (team2) {
            //         match.awayTeamName = team2.teamName;
            //     } else {
            //         match.awayTeamName = '';
            //     }
            //     console.log(match.awayTeamName);
            // })
            // same issue with below as with above
            this.matchesList.forEach((match) => {
                let team1 = this.teams.find((team) => {
                    if (team.teamId == match.homeTeamId) {
                        return true;
                    }
                });
                if (team1) {
                    match.homeTeamName = team1.teamName;
                } else {
                    match.homeTeamName = '';
                }
                let team2 = this.teams.find((team) => {
                    if (team.teamId == match.awayTeamId) {
                        return true;
                    }
                })
                if (team2) {
                    match.awayTeamName = team2.teamName;
                } else {
                    match.awayTeamName = '';
                }
            })
        }
        
    }
}
</script>

<style scoped>

div {
    margin-left: 140px;
    padding: 1em;
}

</style>