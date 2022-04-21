<template>

  <div id="ev-container-body">
    <div>
        <div class="events">
          <div id="past">
          <h3> Past Events </h3>
            <event-table class="past-events" v-bind:filteredList="pastEventArray"/>
          </div>
          <div id="current">
            <h3 id="live-events"> Current Events </h3>
              <event-table class="live-events" v-bind:filteredList="currentEventArray"/>
          </div>  
          <div id="future">
            <h3 id="upcoming-events"> Upcoming Events </h3>
            <event-table class="upcoming-events" v-bind:filteredList="futureEventArray"/>  
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
      tournamentArray: [],
      currentDate: ''
    }
  },
  created() {
    TournamentService.getAllTournaments().then((response) => {
      if (response.status == 200) {
        this.tournamentArray = response.data;
      }
    })
    this.currentDate = new Date();
  },
  computed: {
    pastEventArray() {
      const pastEvents = this.tournamentArray.filter((event) => {
        let convertedDate = new Date(event.endDate)
        if (convertedDate < this.currentDate) {
          return true;
        }
        return false;
      })
      return pastEvents
    },
    futureEventArray() {
      const futureEvents = this.tournamentArray.filter((event) => {
        let convertedDate = new Date(event.startDate)
        if (convertedDate > this.currentDate) {
          return true;
        }
        return false;
      })
      return futureEvents;
    },
    currentEventArray() {
      const currentEvents = this.tournamentArray.filter((event) => {
        let convertedStartDate = new Date(event.startDate);
        let convertedEndDate = new Date(event.endDate);
        if (convertedStartDate <= this.currentDate && convertedEndDate >= this.currentDate) {
          return true;
        }
        return false;
      })
      return currentEvents;
    }
  }
}
</script>


<style scoped>

.events{
  display: flex;
  flex-direction: row;
  color: white;
  justify-content: center;
  
}

#ev-container-body{
  margin: auto;
  margin-top: 2.5%;
}

#live-events{


  /* padding-inline-end: 9%;
  padding-inline-start: 20%;
  text-decoration-line: underline;
  text-decoration-style: double;
  text-decoration-skip-ink: none;
  font-size: 175%;
   */
}

/* #upcoming-events{
  padding: 5%

} */

#past-events{
  /* padding-inline-start: 30%;
  text-decoration-line: underline;
  text-decoration-style: double; 
  font-size: 175%; */
}
/* 
#live-events, #past-events, #upcoming-events {
  margin-right: 1rem;
} */

.view-more{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
}

#past{
  margin-right: 4%;
}

#live-events{
  padding: 0px;
}

#current{
  margin-right: 4%;
  border-right: 2px  solid goldenrod;
  border-left: 2px  solid goldenrod;
  
  height: 100vh;
  padding-right: 4%;
  padding-left: 4%;
}

h3 {
 color: #DC8400; 
  padding-inline-end: 9%;
  padding-inline-start: 20%;
  text-decoration-line: underline;
  text-decoration-skip-ink: none;
  font-size: 175%;
}


</style>
