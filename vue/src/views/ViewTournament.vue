<template>
  <div>
      <tournament-details v-bind:tournamentID="$route.params.id" />
      <!-- TO-DO: add tournament bracket component and join/edit/invite buttons-->
  </div>
</template>

<script>
import TournamentDetails from '../components/TournamentDetails.vue'
export default {
  components: { TournamentDetails },
}
</script>

<style>

</style>