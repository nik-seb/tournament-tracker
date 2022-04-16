<template>
  


</template>

<script>
import TournamentDetails from '@/components/TournamentDetails.vue'
import invitationService from '@/services/InvitationService.js'
export default {

    name: 'create-invite',
    data(){
        return{
            newInvite:{

                invitationId: 1,
                tournamentId: 1,
                teamId: 1,
                organizerId: 1,
                inviteStatus: ''
                
            }
        }
    },
    created(){
        
        this.newInvite.tournamentId = this.$store.state.tournamentId

    },

   methods:{
       createInvite(){
           invitationService.createInvite(this.newInvite).then(response =>{

               if(response.data === 201){
                   this.inviteStatus = 'PENDING'
               }


           })
           


       }
   }

}
</script>


<style>

</style>