<template>

    <body>
    <div>
      <!-- title and pic should be moved to Home view; will need to move related CSS too -->
       <h1 id="company-name"> RANNS Tournament Displays™ </h1>
         <div class="tournament-picture">
              <img src="../assets/tournament_picture.jpg" alt="example of tournament picture">         
         </div> 
          <div class="events">
          <!-- create a v-if condition if date is less than end date display -->
          <p id="past-events"> Past Events </p>
            <event-table class="prior-events" v-bind:filteredList="tournamentArray"/>
            
          <!-- create a v-if condition if date is between start date and end date display -->

          <p id="live-events"> Current Events </p>
            <event-table class="live-events" v-bind:filteredList="tournamentArray"/>

          <!-- create a v-if condition if date is greater than end date display -->
          <p id="upcoming-events"> Upcoming Events </p>
          <event-table class="upcoming-events" v-bind:filteredList="tournamentArray"/>  
   </div>   
          </div>

 </body>
</template>


<script>
import EventTable from './EventTable.vue';
import TournamentService from '@/services/TournamentService.js'
export default {
  components: { EventTable },
  data(){
    return {
      tournamentArray: []
    }
  },
  created() {
    TournamentService.getAllTournaments().then((response) => {
      if (response.status == 200) {
        this.tournamentArray = response.data;
      }
    })
  }
}
</script>

<style scoped>

#company-name{
  display: flex;
  justify-content: center;
  font-style: oblique;
  font-weight: 80%;
}

.tournament-picture {

  max-height: 500px;
  display: flex;
  justify-content: center;
  flex-direction: row;
}

.events{
  
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  font-family: Georgia, 'Times New Roman', Times, serif;
  font-weight: 55%;
  font-size: 20px;
  padding-top: 1%;
  
}

#live-events{

  border-left:1px solid limegreen ;
  height: 100vh;
  border-right: 1px solid limegreen;
  padding-inline-end: 9%;
  padding-inline-start: 9%;
  text-decoration-line: underline;
  text-decoration-style: double;
  text-decoration-skip-ink: none;
  
}

#upcoming-events{
  text-decoration-line: underline;
  text-decoration-style: double;
  text-decoration-skip-ink: none;
  
}

#past-events{
  text-decoration-line: underline;
  text-decoration-style: double; 
}

.view-more{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
}



</style>