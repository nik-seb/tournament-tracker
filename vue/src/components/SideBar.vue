<template>
         <aside>    
            <nav>
                <ul class="sidebar-nav">
                    <li v-if="this.$store.state.user.role == 'ROLE_HOST'"><router-link v-bind:to="{name: 'create-tournament'}">Create Tournament</router-link></li>
                    <li>Display Tournaments</li>
                    <li>Display Matches</li>
                    <li>Manage Tournaments</li>
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
.sidebar-nav{

    position: fixed;
    border-right: 2px solid gold;
    height: 100%;
    width: 100px;
    padding-top: 5%;

}

aside li{

    padding-top: 50px;
    padding-bottom: 75%;   
    list-style: none; 
    /* justify-content: right; */
    
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