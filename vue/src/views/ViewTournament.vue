<template>
  <div id='tourn-view-body'>
      <tournament-details v-bind:tournamentID="Number($route.params.id)" />
      <tourn-options /> 
      <div id="sections"> <div id="participants"> <participants v-bind:tournamentID="Number($route.params.id)" /></div> <div id="bracket"> <bracket v-bind:tournamentID="Number($route.params.id)" /> </div> </div>
  </div>
</template>

<script>
import Bracket from '../components/Bracket.vue'
import TournamentDetails from '../components/TournamentDetails.vue'
import TournOptions from '../components/TournOptions.vue'
import Participants from '../components/Participants.vue'
export default {
  components: { TournamentDetails, TournOptions, Bracket, Participants },
}
</script>

<style>

#tourn-view-body {
  margin-left: 100px;
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