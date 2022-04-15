<template>
  <div>
      <h2>{{tournament.tournamentName}}</h2>
      <section id="tournament-info">
          <p>{{tournament.sportName}}</p>
          <p>From {{tournament.startDate}} to {{tournament.endDate}}</p>
          <p>{{tournament.description}}</p>
      </section>
  </div>
</template>

<script>
import TournamentService from "@/services/TournamentService.js"

export default {
    name: "tournament-details",
    props: {
        tournamentID: Number
        // TO-DO: Fix error: Invalid prop: type check failed for prop "tournamentID". Expected Number with value 6, got String with value "6".
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
                newTournament.tournamentId = response.data.tournamentId;
                newTournament.tournamentName = response.data.tournamentName;
                newTournament.startDate = response.data.startDate;
                newTournament.endDate = response.data.endDate;
                newTournament.sportId = response.data.sportId;
                newTournament.numOfTeams = response.data.numOfTeams;
                newTournament.description = response.data.description;

                TournamentService.getSportById(response.data.sportId).then((response) => {
                if (response.status == 200) {
                    console.log(response.data.sportName + ' is received from sportid query')
                    newTournament.sportName = response.data.sportName;
                    this.$store.commit("SET_ACTIVE_TOURNAMENT", newTournament);
                    this.tournament = newTournament;
                }
                });
            }
        })
    }
}
</script>

<style scoped>
    h2 {
        text-align: center;
    }
    #tournament-info {
        text-align: center;
    }
</style>