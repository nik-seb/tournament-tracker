<template>
  <div>
      <h1>Create Tournament</h1>
      <create-tournament-form />
  </div>
</template>

<script>
import CreateTournamentForm from "@/components/CreateTournamentForm.vue";

export default {
    name: "Create",
    components: {
        CreateTournamentForm
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