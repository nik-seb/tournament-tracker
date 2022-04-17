<template>  
  <div id='tourn-options'>
      <!-- show if player id associated with user isn't associated with tourn, else display "Leave" -->
      <router-link v-bind:to="{ name: 'join-tournament'}" v-bind:tournamentID="tournamentID"><button id="join">Join</button></router-link>

      <!-- always show -->

     <router-link v-bind:to="{ name: 'create-invite'}" > <button id="invite">Invite</button></router-link>

      <!-- show both if user is organizer and tournament is associated with their id -->
      <button id="modify">Modify</button>
      <button id="delete">Delete</button>
  </div>
</template>

<script>
export default {
  name: 'tournament-options',
  props: {tournamentID: Number},
  // computed() {
  //       playerHasJoinedTeam() {
  //           let teamsList;
  //           TournamentService.getParticipantsInTournament(this.tournamentID).then( (response) => {
  //               if (response.status == 200) {
  //                   teamsList = response.data;
  //                   if (teamsList.filter((team)))
  //               }
  //           })
  //       }
  //   }
}
</script>

<style>
  #tourn-options {
    width: 50%;
    display: flex;
    justify-content: center;
  }
</style>