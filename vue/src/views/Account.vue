<template>
  <div id="account-details">
      
      <form class="account">
          <h1>Account Settings</h1>
          <div class="account-error" role="alert" v-if="accountErrors">
              {{ accountErrorMsg }}
          </div>
          <label for="Change player username"></label>
          <p>The player username is different from your account username!</p>
          <input type="text"
          id="user-name"
          placeholder="username"
          v-model="user.username">

          <input id="host" type="checkbox"
           v-model="checkbox">
          <label for="host"> Enable Host Privilege</label>
      </form>

      
  </div>
</template>

<script>
export default {
name: 'account',
data(){
    return{
        user: {
           role: "user"
        },




     checkbox: false,
     accountErrors: false,
     accountErrorMsg: "There were problems changing this account's details.",
  }
}





}
</script>

<style>

</style>