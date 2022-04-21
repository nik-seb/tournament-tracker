<template>
  <div id="app" class="fixed-bg bg-1">
    <!-- <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
      <router-link v-bind:to="{ name: 'account-details', params: {id: Number($store.state.user.id)}}" v-if="$store.state.token != ''">Account</router-link>
    </div> -->
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


<style>

#nav{
  
  background-color:white;
  margin-left: 140px;
  position: sticky;
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: center;
  height: 20px;
  margin-top: -0.8%;
  text-align: center;
  

}


#main-view {
 
   margin-left: 140px;
   padding-left: 1rem;
}

/* div {
  background-color: #232323;
}

#app {
  height: 100%;
  margin: 0px;
  padding: 0px;
} */

</style>


