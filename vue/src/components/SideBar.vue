<template>
         <aside>    
            <nav>
                <ul class="sidebar-nav">
                    <li id="create">
                   <router-link to="/create" > Create Tournament </router-link>
                    </li>
                    <li>
                   <router-link to="/tournaments/:id"> Display Tournaments </router-link>
                   </li>
                    <li>
                       display matches placeholder
                    </li>    
                    <li>
                        manage tournaments placeholder
                    </li>    
                    <li>
                       contact us placeholder
                    </li>
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

#create{
    display: flex;
    flex-direction: row;
    justify-content: center;
}
</style>