<template>

    <body>
    <div>
       <h1 id="company-name"> RANNS Tournament Displays™ </h1>
         <div class="tournament-picture">
              <img src="../assets/tournament_picture.jpg" alt="example of tournament picture">         
         </div> 
          <div class="events">
             <p id="past-events"> Past Events </p>
             <p id="live-events"> Current Events </p>
             <p id="upcoming-events"> Upcoming Events </p>
          </div>
      <!-- use v commands/event listeners to link to each respective page -->
         <div class="view-more">
          <button id="view-past">View More</button>
          <button id="view-current">View More</button>
          <button id="view-upcoming">View More</button>
        </div>   
   </div>   
 </body>
</template>


<script>
export default {

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