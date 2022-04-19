<template>
  <div>
      <h3>Participants</h3>
                <!-- should display abbreviated list and click to view full list that shows teams and players on teams
                    once teams are fully implemented, display team size and link to team page
                -->
          <ul>
              <li v-for="team in tournamentTeams" v-bind:key="team.teamId">{{team.teamName}}</li>
          </ul>
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

<style>

h3 {
    text-align: center;
}
</style>