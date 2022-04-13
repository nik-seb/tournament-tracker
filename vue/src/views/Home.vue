<template>
 <div>
  <event-containers></event-containers>
  <event-details></event-details>
</div> 
</template>

<script>
import EventContainers from '@/components/EventContainers';
import EventDetails from '@/components/EventDetails'



export default {

components:{
  EventContainers,
  EventDetails
},

  name: "home"

};

</script>
