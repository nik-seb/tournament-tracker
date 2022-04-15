<template>
  <div>
      <h1>Modify Tournament</h1>
      <modify-tournament-form />
  </div>
</template>

<script>
import ModifyTournamentForm from "@/components/ModifyTournament.vue";

export default {
    name: "Modify",
    components: {
        ModifyTournamentForm
    }
}
</script>

<style>

h1{
    display: flex;
    flex-direction: row;
    justify-content: center;
}
</style>