<template>

    <body>
        
         <aside>
           
            <nav>
                <ul class="sidebar-nav">

                    <li>Create Tournament</li>
                        <router-link ></router-link>
                    <li>Display Tournaments</li>

                    <li>Display Matches</li>

                    <li>About</li>

                    <li>Contact Us</li>

                </ul>
            </nav>
        </aside>
            

    <div>
       <h1 id="company-name"> RANNS Tournament Displays™ </h1>
         <div class="tournament-picture">
              <img src="../assets/tournament_picture.jpg" alt="example of tournament picture">         
         </div> 

        
       

          <div class="events">
             <p id="past-events"> Past Events </p>
             <p id="live-events"> Current Events </p>
             <p id="upcoming-events"> Upcoming Events </p>
          </div>


      <!-- use v commands/event listeners to link to each respective page -->
         <div class="view-more">
          <button id="view-past">View More</button>
          <button id="view-current">View More</button>
          <button id="view-upcoming">View More</button>
        </div>   

        <aside>
            <nav>
            </nav>
        </aside>
   </div> 
    
 </body>
</template>




<script>
export default {

}
</script>

<style scoped>

#company-name{
  display: flex;
  justify-content: center;
  font-style: oblique;
  font-weight: 80%;
}



.tournament-picture {

  max-height: 500px;
  display: flex;
  justify-content: center;
  flex-direction: row;
  
}

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

.events{
  
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  font-family: Georgia, 'Times New Roman', Times, serif;
  font-weight: 55%;
  font-size: 20px;
  padding-top: 1%;
  
}

#live-events{

  border-left:1px solid limegreen ;
  height: 100vh;
  border-right: 1px solid limegreen;
  padding-inline-end: 9%;
  padding-inline-start: 9%;
  text-decoration-line: underline;
  text-decoration-style: double;
  text-decoration-skip-ink: none;
  
}

#upcoming-events{
  text-decoration-line: underline;
  text-decoration-style: double;
  text-decoration-skip-ink: none;
  
}

#past-events{
  text-decoration-line: underline;
  text-decoration-style: double; 
}

.view-more{
    display: flex;
    flex-direction: row;
    justify-content: space-around;
}

aside img{

    background-color: white;
}



</style>