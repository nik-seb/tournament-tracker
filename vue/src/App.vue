<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link v-bind:to="{ name: 'Login' }" v-if="$store.state.token == ''"></router-link>
    </div>
    <router-view />
  </div>
</template>

<style scoped>

#nav{
  display: flex;
  flex-direction: row;
  justify-content: right;
}

</style>


