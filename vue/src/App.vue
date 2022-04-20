<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
      <router-link v-bind:to="{ name: 'account-details', params: {id: Number($store.state.user.id)}}" v-if="$store.state.token != ''">Account</router-link>
    </div>
    <side-bar/>
    <router-view id="main-view" />
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
div { background-color: rgb(197, 197, 195);
}
@import url(https://fonts.googleapis.com/css?family=Lato);
html, body {
margin: 0%;
padding: 0%;  
}
#nav{
  margin-block-start: -10px;
  position: sticky;
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: center;
  height: 20px;
  top: 0%;
  font-family: Lato, sans-serif;
  color: #121414;


}
div nav {
  font-family: Lato, sans-serif;
  color: #121414;
  text-decoration: none;
  text-transform: uppercase;
  margin-left: -35%;
}

  

#main-view {
   margin-left: 140px;
   padding-left: 1rem;
}

</style>


