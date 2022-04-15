<template>

  <div id="ev-container-body">
    <div>
        <div class="events">
          <!-- create a v-if condition if date is less than end date display -->
          <div id="past">
          <p id="past-events"> Past Events </p>
            <event-table class="past-events" v-bind:filteredList="tournamentArray"/>
          </div>
          <div id="current">
            <p id="live-events"> Current Events </p>
              <event-table class="live-events" v-bind:filteredList="tournamentArray"/>
          </div>  
          <div id="future">
            <p id="upcoming-events"> Upcoming Events </p>
            <event-table class="upcoming-events" v-bind:filteredList="tournamentArray"/>  
          </div>
        </div>   
    </div>

  </div>
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

.events{
  display: flex;
  flex-direction: row;
  margin-left: 3%;
  margin-right: 3%;
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
}

#current{
  
  padding-right: 15%;
}

</style>
