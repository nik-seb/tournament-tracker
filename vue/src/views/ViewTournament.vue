<template>
  <div id='tourn-view-body'>
      <tournament-details v-bind:tournamentID="Number($route.params.id)" />
      <tourn-options v-if="isOpen" v-bind:tournamentID="Number($route.params.id)" v-bind:teams="tournamentTeams"/> 
      <div v-else>This tournament is not accepting new competitors and cannot be modified.</div>
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
      tournamentTeams: [],
      isOpen: true
    }
  },
  created () {
    TournamentService.getParticipantsInTournament(this.$route.params.id).then(response => {
      if (response.status == 200) {
        this.tournamentTeams = response.data;
        console.log(this.tournamentTeams)
      }
    })
    TournamentService.getMatchesByTournamentId(this.$route.params.id).then((response) => {
      if (response.status == 200) {
          if (response.data.length > 0) {
            this.isOpen = false;
          }}
     });
    TournamentService.getUserPlayerID(this.$store.state.user.id).then((response) => {
            if (response.status == 200) {
                if (response.data.playerId != 0) {
                    this.$store.commit("SET_ACTIVE_PLAYER", response.data);
                    this.getPlayerTeam(response.data.playerId);
                }
            } else {
              let blankPlayer = {
                playerName: '',
                playerId: 0,
                userId: this.$store.state.user.id
              }
              this.$store.commit("SET_ACTIVE_PLAYER", blankPlayer)
            }
        })
  },
  methods: {
    getPlayerTeam(playerId) {
      TournamentService.getTeamOfPlayer(playerId).then((response) => {
                if (response.status == 200) {
                    this.$store.commit("SET_ACTIVE_TEAM", response.data)
                }
            })
    }
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