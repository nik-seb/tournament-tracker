<template>
  <h1 id="logout">Logout</h1>
</template>

<script>
export default {
  created() {
    this.$store.commit("LOGOUT");
    this.$router.push("/login");
  }
};
</script>

<style scoped>

</style>