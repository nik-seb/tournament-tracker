<template>
         <aside>    
            <nav>
                <ul class="sidebar-nav">
                    <li>Create Tournament</li>
                        <router-link ></router-link>
                    <li>Display Tournaments</li>
                        <router-link></router-link>
                    <li>Display Matches</li>
                        <router-link></router-link>
                    <li>Manage Tournaments</li>
                        <router-link></router-link>
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
    
}

aside img{
    height: 120px;
    width: 125px;
    margin: 0 auto;
}
</style>