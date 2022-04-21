<template>
  <div>
      <div class="container">
            <h3>Participants</h3>
                <!-- should display abbreviated list and click to view full list that shows teams and players on teams
                    once teams are fully implemented, display team size and link to team page
                -->
            <p v-if="tournamentTeams.length == 0">No teams have joined this tournament yet.</p>
            <p v-for="team in tournamentTeams" v-bind:key="team.teamId">{{team.teamName}}</p>
      </div>
  </div>
</template>

<script>
// import TournamentService from "@/services/TournamentService.js";

export default {
    name: 'participants',
    props: {
        tournamentID: Number,
        tournamentTeams: Array
    },
    data() {
        return {
            participants: []
        }
    },
    created() {
        // TournamentService.getParticipantsInTournament(this.tournamentID).then( (response) => {
        //         if (response.status == 200) {
        //             this.participants = response.data;
        //         }
        //     }
        // )
    }
}
</script>

<style scoped>

div {
  color:white;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

h3 {
    text-align: center;
    color:#DC8400;
}
.container {
    margin: auto;
    border-right: 1px solid #F2C629;
    height: 70vh;
    margin-bottom:1rem;
}

td {
    font-size: 90%;
}

</style>