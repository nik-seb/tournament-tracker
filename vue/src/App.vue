<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
    </div>
    <side-bar/>
    <router-view />
  </div>
</template>

<script>
import SideBar from './components/SideBar.vue';

export default{
  components:{
    SideBar
  }
}


    SideBar</script>


<style scoped>

#nav{
  display: flex;
  flex-direction: row;
  justify-content: right;
}



</style>


