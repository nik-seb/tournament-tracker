<template>
  <div>
      <h2>{{this.$store.state.activeTournament.name}}</h2>

  </div>
</template>

<script>
import TournamentService from "@/services/TournamentService.js"

export default {
    name: "tournament-details",
    props: {
        tournamentID: Number
    },
    created() {
        TournamentService.getTournamentDetails(this.tournamentID).then((response) => {
            if (response.status == 200) {
                let newTournament = {};
                newTournament.id = response.data.tournamentId;
                newTournament.name = response.data.name;
                newTournament.startDate = response.data.startDate;
                newTournament.endDate = response.data.endDate;
                newTournament.sportId = response.data.sportId;
                newTournament.numOfTeams = response.data.numOfTeams;
                this.$store.commit("SET_ACTIVE_TOURNAMENT", newTournament);
                this.tournament = newTournament;
            }
        })
    }
}
</script>

<style>

</style>