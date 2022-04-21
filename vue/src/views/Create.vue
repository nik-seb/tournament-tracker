<template>
  <div>
      <div id='create-body'>
        <h1>Create Tournament</h1>
        <create-tournament-form />
      </div>
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

<style scoped>

#create-body {
    border-color: goldenrod;
    color:black;
}


h1{
    display: flex;
    flex-direction: row;
    justify-content: center;
    background-color: goldenrod;
    border: thick, dotted;
 position: relative;
  z-index: 1;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;


  background:goldenrod;
  max-width: 360px;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24); 
}


</style>