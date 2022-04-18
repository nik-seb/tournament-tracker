<template>
  <div class="inv">
      <h3>INVITES</h3>
          <ul>
              <li v-for="invitations in invites" v-bind:key="invitations.invitationId">{{ invitations }}</li>
          </ul>
  </div>
</template>

<script>
import InvitationService from '../services/InvitationService.js'

export default {
    name: 'invite-details',
   

    data(){

       return{ 
        invites: [],
        organizerId: this.$store.state.user.id
       }


    },

    created(){


        InvitationService.sentInviteByOrganizerId(this.organizerId).then(response => {

            if(response.status == 200){
                this.invites = response.data
                this.invitationId = response.data.invitationId;
                this.tournamentId = response.data.tournamentId;
                this.teamId = response.data.teamId;
                this.organizerId = response.data.organizerId;
                this.inviteStatus = response.data.inviteStatus;
                
            }

        })

    },

methods: {
    getInviteList() {
        InvitationService.getInviteList()
   },

    getInviteByTournamentId() {
        InvitationService.getInviteByTournamentId(this.tournament.tournamentId).then((response) => {
            if (response.status == 200) {
                this.invitation = response.data;
            }
        });
    },

    getInviteByStatus() {
        InvitationService.getInviteByStatus(this.invitationStatus).then((response) => {
            if (response.status == 200) {
                this.invitation = response.data;
            }
    });
},

    getInvitationByTeamId() {
InvitationService.getInviteByTeamId(this.team.teamId).then((response) => {
            if (response.status == 200) {
                this.invitation = response.data;
            }
        });
    },

    getInviteByOrganizer() {
      InvitationService.getInviteByOrganizer(this.organizer.organizerId).then((response) => {
            if (response.status == 200) {
                this.invitation = response.data;
            }
        });  
    },
    updateInvitationStatus() {
            InvitationService.updateInvitationStatus(this.invitation).then(response => {
                if (response.status == 200) {
                    this.invitation = response.data;
                    
                }
            });
        }
    },
}
</script>

<style>

</style>