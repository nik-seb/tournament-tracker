<template>

 <div>

<!-- create a v-if condition if date is less than end date display -->
  <div class="prior-events" v-if="endDate">
      {{this.$store.state.tournamentList.name}}
      {{this.$store.state.tournamentList.numOfTeams}}
      {{this.$store.state.tournamentList.endDate}} 
  </div>
  
<!-- create a v-if condition if date is between start date and end date display -->

  <div class="live-events" v-if="startDate">
      {{this.$store.state.tournamentList.name}} 
      {{this.$store.state.tournamentList.numOfTeams}}
      {{this.$store.state.tournamentList.startDate}}
      {{this.$store.state.tournamentList.endDate}}   
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
            },
       ],
    }
  },
};
</script>

<style scoped>

</style>