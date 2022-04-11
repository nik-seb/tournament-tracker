<template>
  <div>
      <form v-on:submit.prevent>
          <label for="tournamentName">Tournament Name</label>
          <input type="text" name="tournamentName" v-model="newTournament.name">
          <label for="sportType">Sport or Game</label>
          <select id="sportType" name="sportType">
              <option v-for="sport in sportNames" v-bind:key="sport.sportId" v-bind:value="sport.sportId">{{sport.sportName}}</option>
          </select>
          <!-- TO-DO: create input option for user to add new sport if sport does not exist -->
          <label for="startDate">Start Date</label>
          <input type="date" name="startDate" v-model="newTournament.startDate">
          <label for="endDate">End Date</label>
          <input type="date" name="endDate" v-model="newTournament.endDate">
          <button type="submit">Create tournament</button>
      </form>
  </div>
</template>

<script>
import tournamentService from '@/services/tournamentService.js';

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
            sportNames: []
        }
    },
    created(){
        tournamentService.getSportsList().then((response) => {
            this.sportNames = response.data;
        });
        // TO-DO: external API call to find holidays - or might that be generated when range is selected?
    },
    methods: {
        createTournament() {
            tournamentService.createTournament(this.newTournament).then((response) => {
                if (response.status == 200) {
                    // TO-DO: push router to new tournament page
                }
            })
        }
    }
}
</script>

<style>

</style>