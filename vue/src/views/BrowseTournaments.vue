<template>
  <div>
     <h1>Browse Tournaments</h1>
    <table>
      <thead id= "tblUsers">
        <tr>
          <th>Tournament Name</th>
          <th>Sport Name</th>
          <th>Start Date</th>
          <th>End Date</th>
          <th>Status</th>
          <th>Sort By:</th>
        </tr>
      </thead>
      <tbody>
          <tr>
            <td>
              <input type="">
            </td>
             <td>
            <select id="sport" name="sport" v-model="currentSportId.sportId">
              <!-- Can't convince it to preview a "Select sport" as first option -->
              <option value='' disabled></option>
              <option v-for="sport in sports" v-bind:key="sport.sportId" v-bind:value="sport.sportId">{{sport.sportName}}</option>
          </select>
            </td>
             <td>
              <input type="">
            </td>
             <td>
              <input type="">
            </td>
            <td>
              <select id="status">
              <option value="active">Active</option>
              <option value="complete">Complete</option>
              <option value="all">Show All</option>
              </select>
            </td>
            <td><select id="sort-by">
              <option value=""></option>
              <option value="name">Name</option>
              <option value="sport">Sport</option>
              <option value="earliest">Earliest</option>
              <option value="latest">Latest</option>
              </select>
          </td>
          </tr>
          <tr v-for="tournament in tournamentArray" v-bind:key="tournament.tournamentId">
            <td>{{tournament.tournamentName}}</td>
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
      tournamentArray: [],

      currentSportId: 1,

      sports: [],

      tournamentStatus: 'all'
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
          this.tournamentArray.forEach((event) => {
            let foundSport = this.sports.find((sport) => {
              if (event.sportId == sport.sportId) {
                return true;
              }
            })
            event.sportName = foundSport.sportName;
          })
        }
      })
    }
  }

}
</script>

<style scoped>
table {
  margin-top: 20px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  margin-bottom: 20px;
}
td, th {
  border:goldenrod 1px; 
  text-align: left;
  padding:8px;
}
th {
  text-transform: uppercase;
  background-color: goldenrod;
}
td {
  padding: 10px;
}
tr.disabled {
  color: red;
}
input,
select {
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