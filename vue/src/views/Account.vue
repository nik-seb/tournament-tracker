<template>
  <div id="account-details">
      
      <form class="account">
          <h1>Account Settings</h1>
          <div class="account-error" role="alert" v-if="accountErrors">
              {{ accountErrorMsg }}
          </div>
            <p>Current user role: {{$store.state.user.role == 'ROLE_USER' ? 'User' : 'Tournament Host'}} </p>
            <div v-if="$store.state.user.role == 'ROLE_USER'">
            <p>Interested in switching roles so you can now create a tournament?</p>
            <p>Hit the button below to enable host privileges!</p>
            <!-- confirm button -->
            <button class="isHost" v-on:click.prevent="updateAccount()"> Enable Host</button>
            </div>
      </form>

       <div>
         <h3>Invites Received</h3>  
         <invite-details />
         <p></p>

      </div> 
  </div>
  
</template>


<script>
import authService from '../services/AuthService';
import InviteDetails from '../components/InviteDetails.vue'

export default {
    name: 'account',
    props: ['userId'],
    data(){
        return {
            id: 0, 
            role: "",
            checkbox: false,
            accountErrors: false,
            accountErrorMsg: "There were problems changing this account's details.",
        }
    },
    methods: {

        updateAccount(){    
            const account = {
                id: this.$store.state.user.id,
                role: "ROLE_HOST"
            };

            if(confirm('Are you sure about this?')){
            
                authService.updateAccount(account).then(response => {
                
                if(response.status === 200){
                    alert('testing')
                    this.$store.state.user.role = 'ROLE_HOST'
                    this.$store.commit('SET_USER', this.$store.state.user)
                    }
                })

            }
        }

    },
    components:{
        InviteDetails
    }

}
</script>

<style scoped>

form.account {
    position: relative;
  z-index: 1;
background-color: #232323;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);

}


</style>