<template>

 <div>

  <tr class="prior-events"  v-for="tournament in this.$store.state.tournamentList" :key="tournament.id">

      {{tournament.name}}
      {{tournament.numOfTeams}}
      {{tournament.endDate}} 

  </tr>
  <div class="live-events" v-if="startDate ">
      {{tournament.name}} 
      {{tournament.numOfTeams}} Number of teams
      {{tournament.startDate}}  
      {{tournament.endDate}}   
 </div>

<!-- create a v-if condition if date is greater than end date display -->

  <div class="upcoming-events" v-if="startDate">
      {{this.$store.state.tournamentList.name}}
      {{this.$store.state.tournamentList.numOfTeams}}
      {{this.$store.state.tournamentList.startDate}}
  </div>

 </div> 

</template>

<script>

export default {
    name: "event-details-row",
data(){
    return{

        tournamentList: [
            {
            name: '',
            startDate: '',
            endDate: '',
            sportId: '',
            numOfTeams: '', 
            id: 0  
            },
       ],
    }
    
  },


        
};
</script>

<style scoped>

</style>