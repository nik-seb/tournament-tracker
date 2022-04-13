<template>

    <body>
    <div>
      <!-- title and pic should be moved to Home view; will need to move related CSS too -->
       <h1 id="company-name"> RANNS Tournament Displays™ </h1>
         <div class="tournament-picture">
              <img src="../assets/tournament_picture.jpg" alt="example of tournament picture">         
         </div> 
          <div class="events">
            <div id="past">
          <!-- create a v-if condition if date is less than end date display -->
          <p id="past-events"> Past Events </p>
            <event-table class="prior-events" v-bind:filteredList="tournamentArray"/>
            </div>
          <!-- create a v-if condition if date is between start date and end date display -->
<div id="current">
          <p id="live-events"> Current Events </p>
            <event-table class="live-events" v-bind:filteredList="tournamentArray"/>
</div>
<div id="future">
          <!-- create a v-if condition if date is greater than end date display -->
          <div>
          <p id="upcoming-events"> Upcoming Events </p>
          <event-table class="upcoming-events" v-bind:filteredList="tournamentArray"/>  
</div>
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
  padding-left: 5%;
  display: flex;
  justify-content: center;
  flex-direction: row;
}

.events{
  display: flex;
  flex-direction: row;
<<<<<<< HEAD
  margin-left: 13%;
=======
  justify-content: space-evenly;
  font-family: Georgia, 'Times New Roman', Times, serif;
  font-weight: 55%;
  font-size: 20px;
  padding-top: 1%;
  /* align-items: center; */
  /* margin: 20px */
  
>>>>>>> 4799b333631cb2c5e57377e00b79a8ae143c4c54
}

#live-events{


  padding-inline-end: 9%;
  padding-inline-start: 20%;
  text-decoration-line: underline;
  text-decoration-style: double;
  text-decoration-skip-ink: none;
<<<<<<< HEAD
  font-size: 175%;
  
=======
>>>>>>> 4799b333631cb2c5e57377e00b79a8ae143c4c54
}

#upcoming-events{
  padding-inline-start: 17%;
  text-decoration-line: underline;
  text-decoration-style: double;
  text-decoration-skip-ink: none;
  font-size: 175%;
  
}

#past-events{
  padding-inline-start: 30%;
  text-decoration-line: underline;
  text-decoration-style: double; 
  font-size: 175%;
}

.view-more{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
}

#past{
  margin-right: 10%;
}

#current{
  
  padding-right: 15%;
}

</style>
