<template>
  <div id='tourn-view-body'>
      <tournament-details v-bind:tournamentID="Number($route.params.id)" />
      <tourn-options v-bind:tournamentID="Number($route.params.id)"/> 
      <router-view />
       <!--view will link to the given options as a child route  -->
      <div id="sections"> <div id="participants"> <participants v-bind:tournamentID="Number($route.params.id)" v-bind:tournamentTeams="tournamentTeams" /></div> <div id="bracket"> <bracket v-bind:tournamentID="Number($route.params.id)" v-bind:tournamentTeams="tournamentTeams" /> </div> </div>
  </div>
</template>

<script>
import Bracket from '../components/Bracket.vue'
import TournamentDetails from '../components/TournamentDetails.vue'
import TournOptions from '../components/TournOptions.vue'
import Participants from '../components/Participants.vue'
import TournamentService from "@/services/TournamentService.js"
export default {
  components: { TournamentDetails, TournOptions, Bracket, Participants },
  data () {
    return {
      tournamentTeams: []
    }
  },
  created () {
    TournamentService.getParticipantsInTournament(this.$route.params.id).then(response => {
      if (response.status == 200) {
        this.tournamentTeams = response.data;
      }
    })
  }
}
</script>

<style>

#tourn-view-body {
  margin-left: 140px;
}

#sections {
  display: flex;
}

#participants {
  width: 50%;
}

#bracket {
  width: 50%;
}

</style>