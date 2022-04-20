<template>
         <aside>    
            <nav>
                <ul class="sidebar-nav">
                    <li v-if="this.$store.state.user.role == 'ROLE_HOST'"><router-link v-bind:to="{name: 'create-tournament' }">Create Tournament</router-link></li>
                    <li>Display Tournaments</li>
                    <li>Display Matches</li>
                    <li>Manage Tournaments</li>
                    <li v-if="this.$store.state.user.role == 'ROLE_HOST'"><router-link v-bind:to="{name: 'create-invite' }">Invite Form</router-link></li>
                    <li>Contact Us</li>
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
    margin-block-start: 0%;
    position: fixed;
    border-right: 2px solid gold;
    height: 100%;
    width: 100px;
    padding-top: 5%;
    background-color: gold;
}

aside li{

    display: grid;
    padding-bottom:55%;   
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