<template>
  <div>
      <h2>{{tournament.name}}</h2>

  </div>
</template>

<script>
import TournamentService from "@/services/TournamentService.js"

// might want to set this in store as "activeTournament" so there's no need to pass it all around to view, join, edit, etc
// could do the same with retrieved tournament list
export default {
    name: "tournament-details",
    data () {
        return {
            tournament: {
                name: '',
                startDate: '',
                endDate: '',
                sportId: '',
                numOfTeams: '',
                id: ''
            }
        }
    },
    props: {
        tournamentID: Number
    },
    created() {
        TournamentService.getTournamentDetails(this.tournamentID).then((response) => {
            if (response.status == 200) {
                this.tournament.id = response.data.tournamentId;
                this.tournament.name = response.data.name;
                this.tournament.startDate = response.data.startDate;
                this.tournament.endDate = response.data.endDate;
                this.tournament.sportId = response.data.sportId;
                this.numOfTeams = response.data.numOfTeams;
            }
        })
    }
}
</script>

<style>

</style>