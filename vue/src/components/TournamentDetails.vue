<template>
  <div>
      <h2>{{this.$store.state.activeTournament.name}}</h2>
      <section id="tournament-info">
          <p>{{tournament.sport}}</p>
          <p>{{tournament.startDate}} - {{tournament.endDate}}</p>
      </section>
      <section id="participants">
          <h3>Participants</h3>
          <!-- need method to retrieve participants in tournament 
          should display abbreviated list and click to view full list that shows teams and players on teams-->
      </section>
  </div>
</template>

<script>
import TournamentService from "@/services/TournamentService.js"

export default {
    name: "tournament-details",
    props: {
        tournamentID: Number
    },
    data(){
        return {
            tournament: {}
        }
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
                newTournament.sportName = this.getSportName(response.data.sportId);
                newTournament.numOfTeams = response.data.numOfTeams;
                this.$store.commit("SET_ACTIVE_TOURNAMENT", newTournament);
                this.tournament = newTournament;
            }
        })
    },
    methods: {
        // either this or find a better time to load sports into store, instead of just on create tournament
        getSportName(id) {
            TournamentService.getSportName(id).then((response) => {
                if (response.status == 200) {
                    return response.data.sportId;
                }
            });
        }
    }
}
</script>

<style scoped>
    #tournament-info {
        text-align: center;
    }
</style>