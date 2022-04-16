<template>
    <div>
        <h2> Edit the matches for this bracket</h2>
        <edit-match-form v-for="match in matches" v-bind:key="match.matchId" v-bind:Match="match"/>
        <button>Return to tournament page</button>
    </div>
</template>

<script>
import EditMatchForm from '@/components/EditMatchForm.vue'
export default {
    name: 'manage-bracket',
    props: {tournamentID: Number},
    components: {
        EditMatchForm
    },
    created () {
        // Get matches for tournament id
    },
    data () {
        return {
            matches: [
                {
                    matchId: 1,
                    tournamentId: 1,
                    startDate: '2022-02-01',
                    startTime: '12:10:00',
                    homeTeamId: '1',
                    awayTeamId: '2',
                    locationId: '1',
                    winningTeamId: null,
                    roundNumber: '1'
                },
                {
                    matchId: 2,
                    tournamentId: 1,
                    startDate: '2022-02-03',
                    startTime: '08:00:00',
                    homeTeamId: '3',
                    awayTeamId: '4',
                    locationId: '2',
                    winningTeamId: null,
                    roundNumber: '1'
                }
            ]
        }
    }
}
</script>

<style>

</style>