<template>
  <div>
      <form v-on:submit.prevent="createTournament()">
          <label for="tournamentName">Tournament Name</label>
          <input type="text" name="tournamentName" v-model="newTournament.name">
          <label for="sportType">Sport or Game</label>
          <select id="sportType" name="sportType" v-model="sportSelection">
              <option value='' disabled></option>
              <option v-for="sport in sports" v-bind:key="sport.sportId" v-bind:value="sport.sportId">{{sport.sportName}}</option>
              <option value="newSport">Add New Sport</option>
          </select>
          <p v-if="sportSelection == 'newSport'">
              <label for="newSportName">New Sport Name:</label>
              <input type="text" name="newSportName" id="newSportName" v-model="newSport">
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
            sports: [],
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
        for (let sport in this.$store.sportList) {
            this.sports.push(sport)
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
            this.$store.commit("ADD_TOURN_TO_LIST", this.newTournament);
            TournamentService.createTournament(this.newTournament).then((response) => {
                if (response.status == 200) {
                    // TO-DO: get ID from response to push router to new tournament page
                    this.$router.push({name: 'view-tournament', params: {id: 2}});
                }
            })
        },
        createNewSport() {
            TournamentService.createNewSport(this.newSport).then((response) => {
                if (response == 200) {
                    //something
                }
            });
            this.$store.commit("ADD_SPORT_TO_LIST", this.newSport)
        }
    }
}
</script>

<style>

</style>