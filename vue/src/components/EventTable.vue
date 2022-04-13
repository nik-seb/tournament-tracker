<template>

 <div>

     <table>
         <tr>
             <th>Tournament</th>
             <th>Teams</th>
             <th>Start Date</th>
             <th>End Date</th>
         </tr>
        <tr v-for="tournament in filteredList" v-bind:key="tournament.id">
            <router-link v-bind:to="{ name: 'view-tournament', params: {id: Number(tournament.tournamentId)}}"><td>{{tournament.tournamentName}}</td></router-link>
            <td>{{tournament.numOfTeams}}</td>
            <td>{{tournament.startDate}}</td>
            <td>{{tournament.endDate}}</td>
        </tr>         
     </table>

 </div> 

</template>

<script>
export default {
    name: "event-table",
    // when filtering using information, change this.$store ref above to filteredList
    // filter tournaments in containing view, then pass in different list depending on whether past, present, future
    props: {
        filteredList: Array
    }
};
</script>

<style scoped>

</style>