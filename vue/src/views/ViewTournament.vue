<template>
  <div>
      <tournament-details v-bind:tournamentID="$route.params.id" />
      <tourn-options />
      <!-- TO-DO: add tournament bracket component-->
  </div>
</template>

<script>
import TournamentDetails from '../components/TournamentDetails.vue'
import TournOptions from '../components/TournOptions.vue'
export default {
  components: { TournamentDetails, TournOptions },
}
</script>

<style>

</style>