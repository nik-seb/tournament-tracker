<template>
  <div>
      <h3>Participants</h3>
                <!-- need method to retrieve participants in tournament 
          should display abbreviated list and click to view full list that shows teams and players on teams-->
          <ul>
              <li>Player 1 </li>
              <li>Player 2 </li>
              <li>Player 3 </li>
          </ul>
  </div>
</template>

<script>
export default {
    name: 'participants',
    props: {
        tournamentID: Number
    }
}
</script>

<style>
</style>