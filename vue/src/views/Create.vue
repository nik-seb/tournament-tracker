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

</style>