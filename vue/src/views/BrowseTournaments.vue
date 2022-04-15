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
              <input type="">
            </td>
             <td>
              <input type="">
            </td>
             <td>
              <input type="">
            </td>
             <td>
              <input type="">
            </td>
             <td>
              <input type="">
            </td>
             <td>
              <input type="">
            </td>
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

    <form action="">
      <div>
        <label for="">
          <input type="text">
        </label>
      </div>
      <div>
        <label for="">
          <input type="text">
        </label>
      </div>
      <div>
        <label for="">
          <input type="text">
        </label>
      </div>
      <div>
        <label for="">
          <input type="text">
        </label>
      </div>
    </form>

  </div>
</template>
<script>
  // import TournamentDetails from "@/components/TournamentDetails.vue";
export default {
  data() {
    return {
      tournament: {
         tournamentName: 'aeaeaear',
         sportName: 'etertsb',
         startDate: '444444',
         endDate: '5555555',
         description: 'cesrtrtttttttt',
      },

      form: {},
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