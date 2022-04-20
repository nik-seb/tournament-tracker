<template>
<body>
   <header>
       <h1>Invite to Tournament</h1>
    
    </header> 

       <nav>
           <a href=""></a>
       </nav>

      <p id="invTournament">Please enter the selected tournament you would like to send an invite for</p>   
      <p id="invTeam">Please enter the selected team you would like to send an invite for </p>
      <form id='invForm' action="invite-form" v-on:submit.prevent="createForm()">
    
      
      <label for="tournamentNames">Tournament Names: </label>
      <select id="tournamentName" name="tournamentName" v-model="inviteForm.tournamentId">
      <option value='' disabled></option>
      <option v-for="tournament in tournamentList" v-bind:key="tournament.tournamentId" v-bind:value="tournament.tournamentId">{{tournament.tournamentName}}</option>
      </select>

    <!-- team addition  -->
      <label for="teamName"> Team Names: </label>
      <select id="teamName" name="teamName" v-model="inviteForm.teamId">
      <option value='' disabled> </option>
      <option v-for="team in teamList" v-bind:key="team.teamId" v-bind:value="team.teamId">{{ team.teamName }}</option>
     
      </select>
    <!-- team addition  -->
      
      <button>Save</button>
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

          







            // this.$store.commit('SAVE_FORM', this.form);
            // this.form = {
            //     tournamentName: '',
            //     teamName: ''
            // };
        }
    }
}

</script>

<style>

#invForm{
    display: flex;
    flex-direction: row;
    justify-content: center;
    padding-top: 2.5%;
}

/* .invitation-form input, .invitation-form button {
    margin: 10px;
    font-size: 1rem;

    display: flex;
    flex-direction: row;
    justify-content: center;
} */

</style>