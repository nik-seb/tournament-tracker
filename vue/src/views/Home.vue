<template>
<body>
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
</body>
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
  display: flex;
  justify-content: center;
  flex-direction: row;
  padding-right: 2%;
}


#company-name{
  font-family: "Roboto", sans-serif;
  display: flex;
  justify-content: center;
  padding-right: 2%;
  font-style: oblique;
  font-weight: 80%;
}


</style>