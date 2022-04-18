<template>
    <div>
        <h2> Edit the matches for this bracket</h2>
        <edit-match-form v-for="match in matchesList" v-bind:key="match.matchId" v-bind:Match="match"/>
        <router-link v-bind:to="{name: 'view-tournament', params: {id: this.tournamentID}}"><button>Return to tournament page</button></router-link>
    </div>
</template>

<script>
import EditMatchForm from '@/components/EditMatchForm.vue'
import TournamentService from '@/services/TournamentService.js'
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
                }
            })
        } else {
            this.matchesList = this.matches;
        }
    },
    data () {
        return {
            matchesList: []
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