<template>
    <div>
        <form v-on:submit.prevent="saveMatch()" v-if="match.winningTeamId == 0">
            <p>{{match.homeTeamName}} vs {{match.awayTeamName}} </p>

            <label for="date">Select a date for this match: </label>
            <input type="date" v-bind:id="'date' + match.matchId" value="date" v-model="match.startDate">

            <label for="date">Select a time for this match: </label>
            <input type="time" v-bind:id="'time' + match.matchId" value="time" v-model="match.startTime">

            <label for="location">Select a location for this match: </label>
            <select id="location" name="location" v-model="match.locationId">
              <option value='' disabled></option>
              <option v-for="location in locations" v-bind:key="location.locationId" v-bind:value="location.locationId">{{location.cityName}}, {{location.stateName}}</option>
          </select>

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
            match: this.Match,
            locations: []
        }
    },
    created() {
        TournamentService.getAllLocations().then((response) => {
            if (response.status == 200) {
                this.locations = response.data;
            }
        })
    },
    methods: {
        saveMatch() {
            TournamentService.updateMatch(this.match).then(response => {
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