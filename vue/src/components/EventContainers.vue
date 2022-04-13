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
          <div id="past">
          <p id="past-events"> Past Events </p>
            <event-table class="prior-events" />
         </div> 
          <!-- create a v-if condition if date is between start date and end date display -->
          <div id="current">
          <p id="live-events"> Current Events </p>
            <event-table class="live-events" />
          </div>
          <div id="future">
          <!-- create a v-if condition if date is greater than end date display -->
          <p id="upcoming-events"> Upcoming Events </p>
          <event-table class="upcoming-events" />  
          </div>
  </div>   
          </div>

 </body>
</template>


<script>
import EventTable from './EventTable.vue';
export default {
  components: { EventTable }
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
  margin-left: 13%;
}

#live-events{


  padding-inline-end: 9%;
  padding-inline-start: 20%;
  text-decoration-line: underline;
  text-decoration-style: double;
  text-decoration-skip-ink: none;
  font-size: 175%;
  
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
  padding-right: 5%;
}

#current{
  
  padding-right: 15%;
}

</style>