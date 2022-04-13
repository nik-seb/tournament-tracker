<template>  
  <div id='tourn-options'>
      <!-- show if player id associated with user isn't associated with tourn, else display "Leave" -->
      <button id="join">Join</button>

      <!-- always show -->
      <button id="invite">Invite</button>

      <!-- show both if user is organizer and tournament is associated with their id -->
      <button id="modify">Modify</button>
      <button id="delete">Delete</button>
  </div>
</template>

<script>
export default {
  name: 'tournament-options'
}
</script>

<style>
  #tourn-options {
    width: 50%;
    display: flex;
    justify-content: center;
  }
</style>