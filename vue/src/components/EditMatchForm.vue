<template>
    <div>
        <form v-on:submit.prevent="saveMatch()">
            <p>{{match.homeTeamId}} vs {{match.awayTeamId}} </p>

            <label for="date">Select a date for this match: </label>
            <input type="date" v-bind:id="'date' + match.matchId" value="date" v-model="match.startDate">

            <label for="date">Select a time for this match: </label>
            <input type="time" v-bind:id="'time' + match.matchId" value="time" v-model="match.startTime">

            <!-- <label for="location">Select a location for this match: </label>
            <input type="location" v-bind:id="'location' + match.matchId" value="location" v-model="match.locationId"> -->

            <input type="submit" value="Confirm match details">
        </form>

    </div>
</template>

<script>
import TournamentService from '@/services/TournamentService.js';

export default {
    name: 'edit-match-form',
    props: {
        Match: Object
    },
    data () {
        return {
            match: this.Match
        }
    },
    methods: {
        saveMatch() {
            TournamentService.updateMatch(this.match.matchId).then(response => {
                if (response.status == 200) {
                    console.log('updated!')
                    // something to indicate change, like add checkbox to the DOM
                }
            })
        }
    }
}
</script>

<style>

</style>