<template>
<body>
   <header>
       <h1>Invite team to tournament</h1>
    
    </header> 

       

      <p id="invTournament">Please enter the selected tournament and team you would like to send an invite for</p>   
      <form id='invForm' action="invite-form" v-on:submit.prevent="createForm()">
      <label id="tourNames" for="tournamentNames">Tournament Names: </label>
  
      <select id="tournamentName" name="tournamentName" v-model="inviteForm.tournamentId">
      <option value='' disabled></option>
      <option v-for="tournament in tournamentList" v-bind:key="tournament.tournamentId" v-bind:value="tournament.tournamentId">{{tournament.tournamentName}}</option>
      </select>

    <!-- team addition  -->
      <label id="teamNames" for="teamName"> Team Names: </label>
      <select id="teamName" name="teamName" v-model="inviteForm.teamId">
      <option value='' disabled> </option>
      <option v-for="team in teamList" v-bind:key="team.teamId" v-bind:value="team.teamId">{{ team.teamName }}</option>
     
      </select>
    <!-- team addition  -->
      
      <button id="save">Save</button>
  </form>

  </body>
</template>


<script>
import invitationService from '@/services/InvitationService.js'
import TournamentService from '@/services/TournamentService.js'
export default {
    name: "invite-form",
    data() {
        return {
            inviteForm: {
                invitationId: 0,
                tournamentId: 0,
                teamId: 0,
                organizerId: 0,
                inviteStatus: 'TBD'
            },

            tournamentList: [

            ],

            teamList:[

            ],
        }

    },

    components:{
        
    },


 created() {
         
             TournamentService.getAllTournaments().then(response => {

                 if(response.status === 200){
                     this.tournamentList = response.data
                 }
             })

         this.inviteForm.tournamentId = this.$store.state.activeTournament.tournamentId;
         this.inviteForm.organizerId = this.$store.state.user.id;



            TournamentService.getAllTeams().then(response => {

                if(response.status === 200){
                    this.teamList = response.data 
                }
            })

         },

            
 

    methods: {

        createForm() {
 
           invitationService.createInvite(this.inviteForm).then(response => {


               if(response.status === 200){
                   alert("Invite Successful")
                   this.$store.commit('SET_TEAM_LIST')
                   this.inviteStatus = 'PENDING'
                   this.$router.push({name: 'home'})
               }else{
                   console.log(response)
               }
           })
        }
    }
}

</script>

<style>

body {
    font-family: "Roboto", sans-serif;
}

#invForm{
  position: relative;
  background: black #FFFFFF;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
  display: flex;
  flex-direction: column;
}

/* header{
    display: flex;
    flex-direction: row;
    justify-content: center;
} */

#invTournament{
    display: flex;
    flex-direction: row;
    justify-content: center;
    padding-top: 5%;
}

#tourNames{
    margin-bottom: 5%;
}
#teamNames{
    margin-top: 15%;
    margin-bottom: 5%;
}

#save{
    margin-top: 15%;
    margin-bottom: 15%;
    display: block;
    block-size: 50px;
}



</style>