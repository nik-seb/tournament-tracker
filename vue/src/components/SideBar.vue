<template>
         <aside>    
            <nav>
                <ul class="sidebar-nav">
                    <li><router-link v-bind:to="{ name: 'home' }">Home</router-link></li>
                    <li v-if="this.$store.state.user.role == 'ROLE_HOST'"><router-link v-bind:to="{name: 'create-tournament' }">Create Tournament</router-link></li>
                    <li><router-link v-bind:to="{name: 'browse-tournaments' }">Display Tournaments</router-link></li>
                    <li v-if="this.$store.state.user.role == 'ROLE_HOST'"><router-link v-bind:to="{name: 'create-invite' }">Invite Form</router-link></li>
                    <li><router-link v-bind:to="{ name: 'account-details', params: {id: Number($store.state.user.id)}}" v-if="$store.state.token != ''">Account</router-link></li>
                    <li><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link></li>
                </ul>
            </nav>
        </aside>
</template>

<script>
export default {

}
</script>

<style>
@import url(https://fonts.googleapis.com/css?family=Lato);

.sidebar-nav{
    background-color: white;
    margin-block-start: -2.5%;
    position: fixed;
    border-right: 2px solid gold;
    height: 100%;
    width: 100px;
    padding-top: 5%;
    
}

aside li{

    display: grid;
    padding-bottom:45%;   
    list-style: none; 
    position: left;
  display: block;
  font-family: Lato, sans-serif;
  color: #121414;
  text-decoration: none;
  margin-left: -35%;

    
}

aside img{
    height: 120px;
    width: 125px;
    margin: 0 auto;
}

#create{
    display: flex;
    flex-direction: row;
    justify-content: center;
}
</style>