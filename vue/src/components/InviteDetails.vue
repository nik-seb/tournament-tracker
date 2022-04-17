<template>
  <div class="inv">
      <h3>INVITES</h3>
          <ul>
              <li v-for="invitations in invites" v-bind:key="invitations.invitationId">{{ invitations }}</li>
          </ul>
  </div>
</template>

<script>
import invitationService from '../services/InvitationService.js'
export default {
    name: 'invite-details',
   

    data(){

       return{ 
        invites: [],
        organizerId: this.$store.state.user.id
       }


    },

    created(){


        invitationService.sentInviteByOrganizerId(this.organizerId).then(response => {

            if(response.status == 200){
                this.invites = response.data
            }

        })

    }

}
</script>

<style>

</style>