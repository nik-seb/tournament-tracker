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
            sportNames: []
        }
    },
    created(){
        // think this is better off in the store again so there's no need to re-retrieve sports list to get the name when displaying tournament details
        TournamentService.getSportsList().then((response) => {
            this.sportNames = response.data;
        });
        // TO-DO: external API call to find holidays - or might that be generated when range is selected?
    },
    methods: {
        createTournament() {
            TournamentService.createTournament(this.newTournament).then((response) => {
                if (response.status == 200) {
                    // there was a way to retrieve data after creating new row in table - how to return so can get serial ID?
                    // TO-DO: push router to new tournament page; get new ID for that
                    this.$router.push({name: 'view-tournament', params: {id: 2}});
                }
            })
        }
    }
}
</script>

<style>

</style>