<template>
  <div>
      <form v-on:submit.prevent="createTournament">
          <label for="tournamentName">Tournament Name</label>
          <input type="text" name="tournamentName" v-model="newTournament.name">
          <label for="sportType">Sport or Game</label>
          <select id="sportType" name="sportType" v-model="sportSelection">
              <option value='' disabled></option>
              <option v-for="sport in sportNames" v-bind:key="sport.sportId" v-bind:value="sport.sportId">{{sport.sportName}}</option>
              <option value="newSport">Add New Sport</option>
          </select>
          <p v-if="sportSelection == 'newSport'">
              <label for="newSportName">New Sport Name:</label>
              <input type="text" name="newSportName" id="newSportName" v-model="newSportName">
          </p>
          <label for="startDate">Start Date</label>
          <input type="date" name="startDate" v-model="newTournament.startDate">
          <label for="endDate">End Date</label>
          <input type="date" name="endDate" v-model="newTournament.endDate">
          <button type="submit">Create tournament</button>
      </form>
  </div>
</template>

<script>
import TournamentService from '@/services/TournamentService.js';

export default {
    name: "create-tournament-form",
    data() {
        return {
            newTournament: {
                name: '',
                startDate: '',
                endDate: '',
                sportId: '',
                numOfTeams: 0
            },
            sportNames: [],
            sportSelection: '',
            newSport: ''
        }
    },
    created(){
        if (this.$store.sportList.length == 0) {
            TournamentService.getSportsList().then((response) => {
                if (response.status == 200) {
                    this.$store.commit("SET_SPORT_LIST", response.data);
                }
            });
        }
        // TO-DO: external API call to find holidays - or might that be generated when range is selected?
    },
    methods: {
        createTournament() {
            if (this.newSport != '') {
                this.createNewSport();
                // TO-DO: set returned id from createNewSport as this tourn's sportId, or set through new GET by sport name
                    // must set unique constraint on sport name column if the latter
            }
            TournamentService.createTournament(this.newTournament).then((response) => {
                if (response.status == 200) {
                    // there was a way to retrieve data after creating new row in table - how to return so can get serial ID?
                    // TO-DO: push router to new tournament page; get new ID for that
                    this.$router.push({name: 'view-tournament', params: {id: 2}});
                }
            })
        },
        createNewSport() {
            TournamentService.createNewSport(this.newSport);
        }
    }
}
</script>

<style>

</style>