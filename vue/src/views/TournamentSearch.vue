<template>
  <div>
     <h1>Tournament Display</h1>
    <table>
      <thead id= "tblUsers">
        <tr>
          <th>Tournament Name</th>
          <th>Sport Name</th>
          <th>Number Of Teams</th>
          <th>Start Date</th>
          <th>End Date</th>
          <th>Description</th>
        </tr>
      </thead>
      <tbody>
          <tr>
            <td>
              <select id="teams">
              <option value="">Show All</option>
              <option value="Active">Active</option>
              <option value="Disabled">Disqualified</option>
              </select>
            </td>
          </tr>
          <tr id="tournament-info">
            <td>{{tournament.tournamentName}}</td>
            <td>{{tournament.sportName}}</td>
            <td>{{tournament.startDate}}</td>
            <td>{{tournament.endDate}}</td>
            <td>{{tournament.description}}</td>
          </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
  // import TournamentDetails from '../components/TournamentDetails.vue'
export default {
  data() {
    return {
      filter: {
         tournamentName: '',
         sportName: '',
         startDate: '',
         endDate: '',
         description: '',
      },

       
      users:[
        {}
      ]
    }
  },
   
}
</script>

<style scoped>
table {
  margin-top: 20px;
  /* text-emphasis-color: ; */
  font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif
  
}
td {
  padding:10px
}

input, select {
  font-size: 16px;
}


/* tr.disabled {
color:darkred

} */
</style>