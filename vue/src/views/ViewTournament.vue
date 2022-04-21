<template>
  <div id='tourn-view-body'>
    <div id='test-grid'>
      <tournament-details id="details" v-bind:tournamentID="Number($route.params.id)" />
      <div id="upper-div">
        <tourn-options id="options" v-if="isOpen" v-bind:tournamentID="Number($route.params.id)" v-bind:teams="tournamentTeams"/> 
        <div v-else>This tournament is not accepting new competitors and cannot be modified.</div>
        <router-view id="join-tourn" />
      </div>
       <!--view will link to the given options as a child route  -->
      <div class="border"></div>
        <div id="participants"> <participants v-bind:tournamentID="Number($route.params.id)" v-bind:tournamentTeams="tournamentTeams" /></div>
        <div id="bracket"> <bracket v-bind:tournamentID="Number($route.params.id)" v-bind:tournamentTeams="tournamentTeams" /> </div>
    </div>
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
    window.scrollTo(0, 0);
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
                } else {
                  let blankPlayer = {
                  playerName: '',
                  playerId: 0,
                  userId: this.$store.state.user.id
                 }
                 this.$store.commit("SET_ACTIVE_PLAYER", blankPlayer)
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

<style scoped>
div {
  color:white;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

h2, h3 {
  color:#DC8400;
}

#test-grid {
  margin-left: 0px;
  display: grid;
  display:-moz-grid-group;
  display:-ms-grid;
  grid-template-columns: 1fr 2fr;
  grid-template-areas: 
    "header header"
    "options options"
    "border border"
    "participants bracket"
  ;
  text-align: center;
}

#details {
  grid-area: header;
      position: relative;
  z-index: 1;
background-color: #232323;
  max-width: 360px;
  margin: 0 auto 20px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);

}

#participants {
  grid-area: participants;
  width: 90%;
}

#bracket {
  grid-area: bracket;
  width: 90%;
}

#upper-div {
  grid-area: options;
  margin: auto;
}

#options {
  margin: auto;
}

#join-tourn {
  grid-area: join;
}

/* .border {
  margin: auto;
  grid-area: border;
  background-color: goldenrod;
  height: 2px;
    margin-right: 1rem;
    padding-right:1rem;
    width: 80%;
} */

</style>