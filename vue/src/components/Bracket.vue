<template>
  <div>
      <h3>Bracket</h3>
      <p>Schedule TBD</p>
      <img src="../assets/tournament_picture.jpg" alt="example of tournament picture">
  </div>
</template>

<script>
export default {
    name: 'bracket',
    props: {
        tournamentID: Number
    }
}
</script>

<style>
    img {
        width: 500px;
    }
</style>