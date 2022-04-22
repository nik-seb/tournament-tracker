<template>

 <div>

     <p v-show="filteredList.length == 0">No events for this time range.</p>

     <table v-if="filteredList.length > 0">
         <tr>
             <th>Tournament</th>
             <th>Start Date</th>
             <th>End Date</th>
         </tr>
        <tr v-for="tournament in filteredList" v-bind:key="tournament.id">
            <router-link v-bind:to="{ name: 'view-tournament', params: {id: Number(tournament.tournamentId)}}"><td>{{tournament.tournamentName}}</td></router-link>
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
table {
    border-spacing: 3px;
    font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
}
td {
    margin: 0.5rem;
}
</style>