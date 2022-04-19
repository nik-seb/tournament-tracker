<template>
  <div class="inv">
      <h3>INVITES</h3>
          <ul>

              <label for="tournaments">Select a Tournament: </label>
              <select id="tournaments" name="tournaments" v-model="tournaments.tournamentId ">
                   <option value='' disabled></option>
                   <option v-for="tournament in tournaments" v-bind:key="tournament.tournamentId"  v-bind:value="tournament.tournamentId" > {{tournaments.tournamentName}}</option>


              </select>

              <div v-for="player in players" v-bind:key="player.id">
                  {{ players.playerName }}
              </div>
              <div v-for="team in teams" v-bind:key="team.id">
                  {{ teams.teamName }}
              </div>
              <div v-for="tournament in tournaments" v-bind:key="tournament.tournamentId"  v-bind:value="tournament.tournamentId" >
                  {{ tournament.tournamentName }}
              </div> 
              <div v-for="invitation in invitations" v-bind:key="invitation.id">
                  {{ invitation.inviteStatus }}
              </div>

              <!-- <li v-for="invitations in invites" v-bind:key="invitations.invitationId">{{ invitations }}</li>
              <li v-for="invitations in invites" v-bind:key="invitations.teamId">{{invitations.status}}</li> -->
          </ul>
  </div>
</template>

<script>
import InvitationService from '../services/InvitationService.js'
import TournamentService from '../services/TournamentService.js'

export default {
    name: 'invite-details',
   
   props:{
       tournamentID: Number
    },

    data(){

       return{ 
        
        invitations: [],
        teams:[],
        players:[],
        tournaments:[],

        organizerId: this.$store.state.user.id,
        teamId: 0
       }


    },

    created(){


        TournamentService.getAllTournaments().then(response => {

            if(response.data === 200){
                this.tournaments.tournamentName = response.data.tournamentName
            }
        })

        InvitationService.getInviteByTournamentId()

        InvitationService.sentInviteByOrganizerId(this.organizerId).then(response => {

            if(response.status == 200){
                this.invites = response.data
                this.invitationId = response.data.invitationId;
                this.teamId = response.data.teamId;
                this.organizerId = response.data.organizerId;
                this.inviteStatus = response.data.inviteStatus;
                
            }
        })

        // InvitationService.receivedInviteByTeamId().then(response =>{

        //     if(response.status == 200){
        //         this.invites = response.data
        //     }
        // })

    },

methods: {
//     getInviteList() {
//         InvitationService.getInviteList()
//    },

    getInviteByTournamentId() {
        InvitationService.getInviteByTournamentId(this.tournamentId).then((response) => {
            if (response.status == 200) {
                response.data.forEach(element => {
                    this.teams.push(element.teamName)
                    this.tournaments.push(element.tournamentName)
                    this.players.push(element.playerName)
                    this.invites.push(element.inviteStatus)
                });

                    this.invitation = response.data;
                
            }
        });
    },








//     getInviteByStatus() {
//         InvitationService.getInviteByStatus(this.invitationStatus).then((response) => {
//             if (response.status == 200) {
//                 this.invitation = response.data;
//             }
//     });
// },

//     getInvitationByTeamId() {
// InvitationService.getInviteByTeamId(this.team.teamId).then((response) => {
//             if (response.status == 200) {
//                 this.invitation = response.data;
//             }
//         });
//     },

    // getInviteByOrganizer() {
    //   InvitationService.getInviteByOrganizer(this.organizer.organizerId).then((response) => {
    //         if (response.status == 200) {
    //             this.invitation = response.data;
    //         }
    //     });  
    // },
    // updateInvitationStatus() {
    //         InvitationService.updateInvitationStatus(this.invitation).then(response => {
    //             if (response.status == 200) {
    //                 this.invitation = response.data;
                    
    //             }
    //         });
    //     }
    },
}
</script>

<style>

</style>