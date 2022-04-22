<template>
  <div id="browse-body">
     <h1>Browse Tournaments</h1>
     <div>Show:
       <select id="sport" name="sport" v-model="currentSport.sportId" v-on:change="filterBySport()">
              <option value='0'>All</option>
              <option v-for="sport in sports" v-bind:key="sport.sportId" v-bind:value="sport.sportId">{{sport.sportName}}</option>
          </select>
              
     </div>
    <table>
      <thead id= "tblUsers">
        <tr>
          <th>Tournament Name</th>
          <th>Sport Name</th>
          <th>Start Date</th>
          <th>End Date</th>
          <th>Status
            
          </th>
          <th>Sort By:
          
          </th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td>
            <select id="status" v-model="tournamentStatus" v-on:change="filterByActive()">
              <option value="active">Active</option>
              <option value="complete">Complete</option>
              <option value="all">Show All</option>
          </select>
          </td>
          <td>
              <select id="sort-by" v-model="sortMethod">
              <option value="earliest">Starting earliest</option>
              <option value="latest">Starting latest</option>
              <option value="name">Name</option>
              <option value="sport">Sport</option>
              </select>
          </td>
        </tr>
          <tr v-for="tournament in sortByWhat" v-bind:key="tournament.tournamentId">
            <td><router-link v-bind:to="{ name: 'view-tournament', params: {id: Number(tournament.tournamentId)}}">{{tournament.tournamentName}}</router-link></td>
            <td>{{tournament.sportName}}</td>
            <td>{{tournament.startDate}}</td>
            <td>{{tournament.endDate}}</td>
          </tr>
      </tbody>
    </table>

  </div>
</template>
<script>
import TournamentService from '@/services/TournamentService.js'

export default {
  data() {
    return {
      originalTournamentArray: [],
      tournamentArray: [],

      currentSport: {
        sportId: 0
      },
      sports: [],

      tournamentStatus: 'all',
      sortMethod: 'earliest'
    }
  },

  created(){
      TournamentService.getSportsList().then((response) => {
        if (response.status == 200) {
          this.sports = response.data;
          this.getAndMapTournaments();
        }
      })
  },
  methods: {
    // inserts actual sport name into each tournament in tournamentArray
    getAndMapTournaments() {
      TournamentService.getAllTournaments().then((response) => {
        if (response.status == 200) {
          this.tournamentArray = response.data;
          this.mapTournaments();
          this.originalTournamentArray = this.tournamentArray.slice();
        }
      })
    },
    mapTournaments() {
      this.tournamentArray.forEach((event) => {
            let foundSport = this.sports.find((sport) => {
              if (event.sportId == sport.sportId) {
                return true;
              }
            })
            event.sportName = foundSport.sportName;
          })
    },
    compareDateAsc(tournament1, tournament2) {
        if (tournament1.startDate.toString() > tournament2.startDate.toString()) {
            return 1;
        } else if (tournament1.startDate.toString() < tournament2.startDate.toString()) {
            return -1;
        }
        return 0;
    },
    compareDateDesc(tournament1, tournament2) {
        if (tournament1.startDate.toString() > tournament2.startDate.toString()) {
            return -1;
        } else if (tournament1.startDate.toString() < tournament2.startDate.toString()) {
            return 1;
        }
        return 0;
    },
    filterBySport(){
      if (this.currentSport.sportId == 0) {
        this.tournamentArray = this.originalTournamentArray.slice();
      } else {
        TournamentService.getTournamentsBySportId(this.currentSport.sportId).then(response => {
          if (response.status == 200) {
            this.tournamentArray = response.data;
            this.mapTournaments();
          }
        })
      }
    },
    filterByActive() {
      if (this.tournamentStatus == 'all') {
        this.tournamentArray = this.originalTournamentArray.slice();
      }
      if (this.tournamentStatus == 'active') {

        const currentDate = new Date();
        const activeEvents = this.tournamentArray.filter((event) => {
        let convertedEndDate = new Date(event.endDate);
        if (convertedEndDate >= currentDate) {
          return true;
        }
        return false;
      })
      this.tournamentArray = activeEvents;
      }
    }
  },
  computed: {
        sortedByEarliest() {
            return this.tournamentArray.slice().sort(this.compareDateAsc);
        },
        sortedByLatest() {
          return this.tournamentArray.slice().sort(this.compareDateDesc);
        },
        sortByWhat() {
          if (this.sortMethod == 'earliest') {
            return this.sortedByEarliest;
          }
          if (this.sortMethod == 'latest') {
            return this.sortedByLatest;
          }
          return this.tournamentArray;
        }
    }

}
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family: sans-serif;
  margin-bottom: 20px;
}
#browse-body {
  height: 100%;
  min-height: 100vh;
}
/* h1 {
  margin: 235px;
} */
td, th {
  border:goldenrod 1px; 
  text-align: left;
  padding:8px;
}
#tblUsers{
  border:goldenrod 1px; 
  text-align: left;
  padding:8px;
}
th {
  text-transform: uppercase;
  background-color: goldenrod;
  color: black
}
td {
  padding: 10px;
}
tr.disabled {
  color: red;
}
input,
select {
  font-family: "Roboto", sans-serif;
  font-size: 16px;
}

form {
  margin: 20px;
  width: 350px;
}
label {
  width: 140px;
  display: inline-block;
}
button {
  margin-right: 5px;
}

</style>