<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label id="user" for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label id="pass" for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <div class="host"> 
      <input id="isHost" type="checkbox" v-model="checkbox">
      <label for="isHost">Host? </label>
      </div>

      <button id="create" class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
      <router-link id="haveAccount" :to="{ name: 'login' }">Have an account?</router-link>

    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      
      //checkbox grants host or user access
      checkbox: false,
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      }else{
        if(this.checkbox === true){
          this.user.role = 'host'
        }
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>


#register{
   width: 360px;
  padding: 8% 0 0;
  margin: auto;
  font-family: "Roboto", sans-serif;
}

.text-center .form-register {
  margin-top: 10%;
}


.form-register{

  position: relative;
  z-index: 1;
  background: black #FFFFFF;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}

.form-register input{
   font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}

.form-register button {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background-color: goldenrod;
  /* background-image: linear-gradient(45deg,#328f8a,#08ac4b); */
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}

#username{
  margin-top: 5%;
  margin-bottom: 10% ;
 
}

#password{
  margin-top: 5%;

}

#user{
  font-family: "Roboto", sans-serif;
}

#pass{
  padding-top: 5%;
  font-family: "Roboto", sans-serif;
}

.host {
  display: flex;
  flex-direction: column-reverse;
  justify-items: center;
}

#create{
  margin-top: 2.5%;
  margin-bottom: 2.5%;
  font-family: "Roboto", sans-serif;

}

.host #isHost{
  margin-top: 3.5%;
}

</style>
