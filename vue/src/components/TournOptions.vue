<template>  
  <div id='tourn-options'>
      <!-- show if player id associated with user isn't associated with tourn, else display "Leave" -->
     <router-link v-if="!playerHasJoinedTournament" v-bind:to="{ name: 'join-tournament'}" v-bind:tournamentID="tournamentID"><button id="join">Join</button></router-link>
      <!-- TO-DO  check if host is tournament's organizer-->
      <div v-if="this.$store.state.user.role == 'ROLE_HOST'">
      <!-- show unless bracket has been generated -->
     <router-link v-bind:to="{ name: 'create-invite'}" > <button id="invite">Invite</button></router-link>
      <router-link v-bind:to="{name: 'Modify-tournament'}"> <button id="Modify">Modify</button> </router-link>
      <button id="delete">Delete</button>
      </div>
  </div>
</template>

<script>

export default {
  name: 'tournament-options',
  props: {tournamentID: Number, teams: Array},
  computed: {
        playerHasJoinedTournament() {
            if (this.$store.state.activeTeam.teamId > 0) {
              const teamInTournament = this.teams.find((team) => {
                if (team.teamId == this.$store.state.activeTeam.teamId) {
                  return true;
                }
              })
              if (teamInTournament) {
                return true;
              }
            }
            return false;
        }
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