<template>
  <div>
      <h3>Set winner of this match</h3>
      <!-- some info on the match to confirm they clicked on the right one -->
      <form v-on:submit.prevent="submitWinner()">
          <label for ="winner-select">Please select the winner:</label>
          <select id="winner-select" name="winner-select" v-model="updatedMatch.winningTeamId">
              <option value='' disabled></option>
              <option v-bind:value="updatedMatch.homeTeamId"> {{homeTeamName}} </option>
              <option v-bind:value="updatedMatch.awayTeamId"> {{awayTeamName}} </option>
          </select>
          <button type="submit">Submit match winner</button>
      </form>
  </div>
</template>

<script>
import TournamentService from "@/services/TournamentService.js";

export default {
    name: 'winner-form',
    data () {
        return {
            updatedMatch: {},
            homeTeamName: '',
            awayTeamName: '',
            winner: ''
        }
    },
    methods: {
        submitWinner() {
            confirm("Are you sure you want to set this team as the winner?");
            TournamentService.updateMatchWinner(this.updatedMatch).then((response) => {
                if (response.status == 200) {
                    this.$router.push({name: "view-tournament", params: {id: this.updatedMatch.tournamentId}});
                }
            });
        }
    },
    created() {
        TournamentService.getMatchByMatchId(this.$route.params.id).then((response) => {
            if (response.status == 200) {
                this.updatedMatch = response.data;
                TournamentService.getTeamByTeamId(this.updatedMatch.homeTeamId).then((response) => {
                    if (response.status == 200) {
                        this.homeTeamName = response.data.teamName;
                    }
                });
                TournamentService.getTeamByTeamId(this.updatedMatch.awayTeamId).then((response) => {
                    if (response.status == 200) {
                        this.awayTeamName = response.data.teamName;
                    }
                });
            }
        })
    }

}
</script>

<style>

</style>