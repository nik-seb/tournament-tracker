<template>

  <div id="ev-container-body">
    <div>
        <div class="events">
          <div id="past">
          <p id="past-events"> Past Events </p>
            <event-table class="past-events" v-bind:filteredList="pastEventArray"/>
          </div>
          <div id="current">
            <p id="live-events"> Current Events </p>
              <event-table class="live-events" v-bind:filteredList="currentEventArray"/>
          </div>  
          <div id="future">
            <p id="upcoming-events"> Upcoming Events </p>
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
  margin-left: 140px;
  display: flex;
  flex-direction: row;

  
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
