<template>
 <div>
    <h1 id="company-name"> RANNS Tournament Displays™ </h1>
    <div class="tournament-picture">
             
    </div> 
  <event-containers></event-containers>
  <div></div>
  <div></div>
  <div></div>
  <div>
    <browse-tournaments></browse-tournaments>
  </div>
</div> 
</template>

<script>
import EventContainers from '@/components/EventContainers';
import BrowseTournaments from '../views/BrowseTournaments';


export default {

components:{
  EventContainers,
  BrowseTournaments

},

  name: "home"

};

</script>

<style scoped>
#company-name{
  display: flex;
  justify-content: center;
  font-style: oblique;
  font-weight: 80%;
}


</style>