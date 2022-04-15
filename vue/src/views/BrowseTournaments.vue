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
  // import TournamentDetails from "@/components/TournamentDetails.vue";
export default {
  data() {
    return {
      tournament: {
         tournamentName: 'aeaeaear',
         sportName: 'etertsb',
         startDate: '444444',
         endDate: '5555555',
         description: 'cesrtrttttttttttttttttttttttttttttttttttttttt',
      },
      users:[
        {}
      ]
    }
  },
}
</script>
<style>
</style>