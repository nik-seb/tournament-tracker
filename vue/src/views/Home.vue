<template>
 <div>
    <h1 id="company-name"> RANNS Tournament Displays™ </h1>
    <div class="tournament-picture">
      <img src="../assets/tournament_picture.jpg" alt="example of tournament picture">         
    </div> 

  <event-containers></event-containers>
  <div></div>
  <div></div>
  <div></div>
</div> 
</template>

<script>
import EventContainers from '@/components/EventContainers';



export default {

components:{
  EventContainers

},

  name: "home"

};

</script>

<style scoped>

.tournament-picture {

  max-height: 500px;
  padding-left: 5%;
  display: flex;
  justify-content: center;
  flex-direction: row;
}


#company-name{
  
  display: flex;
  justify-content: center;
  font-style: oblique;
  font-weight: 80%;
}


</style>