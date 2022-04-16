<template>
<body>
   <header>
       <h1>Tournament</h1>
       <p>Invite Form</p>
    </header> 

       <nav>
           <a href=""></a>
       </nav>

  <form action="invite-form" v-on:submit.prevent="saveForm">
      <label for="tournamentName">Tournament Name</label>
      <input class="tournament-name-input" type text="text" name="Tournament Name" v-model="inviteForm.tournamentName" />
      <label for="teamName">Team Name</label>
      <input class="team-name-input" type text="text" name="Team Name" v-model="inviteForm.TeamName" />
      <input type="text">
      <select name="" id="">
          <option value=""></option>
          <p>
              <label for=""></label>
              <input type="text">
          </p>
      </select>
      <button>Save</button>
  </form>
  </body>
</template>


<script>
//import TournamentDetails from @/components/TournamentDetails.vue

export default {
    name: "invite-form",
    data() {
        return {
            InviteForm: {
                tournamentName: '',
                teamName: ''
            }
        }
    },

 methods: {
        saveForm() {
            this.$store.commit('SAVE_FORM', this.form);
            this.form = {
                tournamentName: '',
                teamName: ''
            };
        }
    }
}

</script>

<style>

.invitation-form input, .invitation-form button {
    margin: 10px;
    font-size: 1rem;

    display: flex;
    flex-direction: row;
    justify-content: center;
}

</style>