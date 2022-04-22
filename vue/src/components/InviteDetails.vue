<template>
  <body class="inv">
      <h3></h3>

              <div id="brittneyBitch">
                   <form>
                    <div class="inv" v-for="invite in invitations" v-bind:key="invite.invitationId" v-bind:value="invite.teamId">
                       <p id="uno"> Tournament Name || {{ invite.tournamentName }} || </p>
                        <p id="dos"> Team Name ||  {{ invite.teamName }} || </p>
                        <p id="tres"> Invitation Status || {{ invite.inviteStatus }} </p>
                        <p v-if="invite.inviteStatus == 'TBD'"> 
                         <button  v-bind:value="invite.tournamentId" id="acceptInvite" v-on:click.prevent="acceptInvite(invite)" > Accept Invite </button>

                         <button  v-bind:value="invite.tournamentId" id="declineInvite" v-on:click.prevent="declineInvite(invite)"> Decline Invite </button>
                      </p>     
                    </div> 
                  </form>
                   
              </div>

  </body>
</template>

<script>
import InvitationService from '../services/InvitationService.js'
import TournamentService from '../services/TournamentService.js'

export default {
    name: 'invite-details',

    data(){

       return{         
        invitations: [],
        team: {},
        players:[],
        tournaments:{},
        tournamentID: 0,
        organizerId: this.$store.state.user.id,
        teamId: 0
       }
    },

    created(){
       
        TournamentService.getUserPlayerID(this.$store.state.user.id).then((response) => {
            if (response.status == 200) {
                if (response.data.playerId != 0) {
                    this.$store.commit("SET_ACTIVE_PLAYER", response.data);
                    this.getPlayerTeam(response.data.playerId);
                }else{
                    let blankPlayer = {
                playerName: '',
                playerId: 0,
                userId: this.$store.state.user.id
              }
              this.$store.commit("SET_ACTIVE_PLAYER", blankPlayer)
              }
              }else{
              let blankPlayer = {
                playerName: '',
                playerId: 0,
                userId: this.$store.state.user.id
              }
              this.$store.commit("SET_ACTIVE_PLAYER", blankPlayer)
            }
        })
        

        },
    


methods: {
     getPlayerTeam(playerId) {
      TournamentService.getTeamOfPlayer(playerId).then((response) => {
                if (response.status == 200) {
                    this.$store.commit("SET_ACTIVE_TEAM", response.data)
                    this.teamId = response.data.teamId
                    this.getInviteByTeamId()
                }
            })
    },
        getInviteByTeamId(){
         InvitationService.getInviteByTeamId(this.teamId).then(response => {

            if(response.status === 200){
                this.invitations = response.data;
            }
        })
        },
        acceptInvite(invite){
      
            invite.inviteStatus = "ACCEPTED";

             if(confirm('Are you sure about this?')){
                InvitationService.updateInvitationStatus(invite).then(response => {

                    if(response.status === 200){
                        this.inviteStatus = "ACCEPTED"
                        this.$store.commit('SET_STATUS', this.$store.state.invitationList)
                        this.getTournamentByID(invite.tournamentId);
                    }
                })
         }
        },

        getTournamentByID(tournamentID){
            TournamentService.getTournamentDetails(tournamentID).then(response => {

                if(response.status === 200){
                    this.tournaments = response.data
                    
                    this.getTeamByTeamId();
                }
            })
        },
        declineInvite(invite){
           
            invite.inviteStatus = "DECLINED";

             if(confirm('ARE YOU SURE ABOUT THIS')){
                 InvitationService.updateInvitationStatus(invite).then(response =>{

                     if(response.status === 200){
                         this.inviteStatus = 'DECLINED';
                     }
                 })
             }   
        },
             joinTournament () {
              TournamentService.addParticipantToTournament(this.tournaments.tournamentId, this.team).then((response) => {
                if (response.status == 200) {
                    alert("You have joined the tournament!")
                    this.tournaments.numOfTeams++;
                    TournamentService.modifyTournament(this.tournaments).then((response) => {
                        console.log(response);
                    })
                }
            })
        },
        getTeamByTeamId() {
            TournamentService.getTeamByTeamId(this.teamId).then(response => {
                if (response.status == 200) {
                    this.team = response.data;
                    this.joinTournament()
                }
            })
        }
    } 
}
</script>

<style>
.inv{
    display: flex;
    flex-direction: row;
    justify-content: center;
    margin-top: 5%;
    margin-bottom: 15%;
}

#uno{

}

#dos{

}

#tres{
    
}



</style>