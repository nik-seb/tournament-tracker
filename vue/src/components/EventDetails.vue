<template>

 <div>
  <div class="prior-events">
      {{team.name}} vs {{team.name}}
  </div>
  <div class="live-events">

  </div>
  <div class="upcoming-events">
   
  </div>
 </div> 


</template>

<script>
export default {
    name: "event-details-row",
        props: ["tournament, matches"],

data(){
    return{

    }
  },
};
</script>

<style>

</style>