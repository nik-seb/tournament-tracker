<template>
  <div id="account-details">
      
      <form class="account">
          <h1>Account Settings</h1>
          <div class="account-error" role="alert" v-if="accountErrors">
              {{ accountErrorMsg }}
          </div>
          <label for="Change role"></label>
          <div>
              <p>Current User status: {{$store.state.user.role}} </p> 
          </div>
          <p>Interested in switching roles so you can now create a tournament?</p>
          <p>Hit the button below to enable host privileges!</p>

           
            <!-- confirm button -->
            <button class="isHost" v-on:click.prevent="updateAccount()"> Enable Host</button>

      </form>

      <!-- import auth services and add update to auth service -->
      <!-- display button if only user role -->
  </div>
</template>


<script>
import authService from '../services/AuthService';export default {
name: 'account',
props: ['userId'],
data(){
    return{
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
        })}
    }
   }





}
</script>

<style>

</style>