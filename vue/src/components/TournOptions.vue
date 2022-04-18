<template>  
  <div id='tourn-options'>
    <div v-if="isOpen">
      <!-- show if player id associated with user isn't associated with tourn, else display "Leave" -->
      <router-link v-bind:to="{ name: 'join-tournament'}" v-bind:tournamentID="tournamentID"><button id="join">Join</button></router-link>
      
      <!--broken version below  -->
     <!-- <router-link v-if="!playerHasJoinedTeam" v-bind:to="{ name: 'join-tournament'}" v-bind:tournamentID="tournamentID"><button id="join">Join</button></router-link> -->

      <div v-if="this.$store.state.user.role == 'ROLE_HOST'">
      <!-- show unless bracket has been generated -->
     <router-link v-bind:to="{ name: 'create-invite'}" > <button id="invite">Invite</button></router-link>
      <!-- show both if user is organizer and tournament is associated with their id -->
      <router-link v-bind:to="{name: 'Modify-tournament'}"> <button id="Modify">Modify</button> </router-link>
      <button id="delete">Delete</button>
      </div>
      </div>
      <div v-else>
        This tournament is not accepting new competitors.
      </div>
  </div>
</template>

<script>
import TournamentService from "@/services/TournamentService.js";
// import TeamPlayerService from "@/services/TeamPlayerService.js";

export default {
  name: 'tournament-options',
  props: {tournamentID: Number},
  computed: {
        // playerHasJoinedTeam() {
        //     return this.checkIfPlayerHasJoined;
        // }
    },
  data() {
    return {
      isOpen: true
    }
  },
  methods: {
    // this doesn't work
    // checkIfPlayerHasJoined() {
    //   let teamId;
    //   let teamList;
    //   TeamPlayerService.getTeamByUserId(this.$store.state.id).then((response) => {
    //       if (response.status == 200) {
    //           teamId = response.data.teamId;
    //           if (teamId) {
    //             TournamentService.getParticipantsInTournament(this.tournamentID).then( (response) => {
    //             if (response.status == 200) {
    //               teamList = response.data;
    //               console.log(teamList)
    //               let teamInList = teamList.find((team) => {
    //                 if (team.teamId == teamId) {
    //                   console.log('found!')
    //                   return true;
    //                 }
    //                 console.log(teamInList)
    //                 if (teamInList != 0) {
    //                   return true;
    //                 }
    //               })
    //             }
    //             })
    //           }
    //       }
    //   })
    // }
  },
  created () {
      TournamentService.getMatchesByTournamentId(this.$route.params.id).then((response) => {
      if (response.status == 200) {
        console.log(response.data.length)
          if (response.data.length > 0) {
            this.isOpen = false;
          }}
     });
  }
}
</script>

<style>
  #tourn-options {
    width: 50%;
    display: flex;
    justify-content: center;
  }
</style>