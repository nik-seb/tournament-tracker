<template>
  <body class="inv">
      <h3></h3>

              <div>
              <label for="tournamentNames">Select a Tournament: </label>
              <select id="tournamentName" name="tournamentName" v-model="tournamentID" v-on:change="getInviteByTournamentId()">      
              <option value='' disabled></option>
              <option v-for="tournament in tournaments" 
              v-bind:key="tournament.tournamentId" 
               v-bind:value="tournament.tournamentId" > {{ tournament.tournamentName }}</option>
              </select>
              </div>  

              <div class="teamsTournament" v-for="team in teams" v-bind:key="team.tournamentId" v-bind:value="team.tournamentId" >
                   {{team.teamName}}
              </div>  

              <div>
              <li v-for="invites in invitations" v-bind:key="invites.invitationId" v-bind:value="invitationId"> {{invites.teamId}} {{ invites.inviteStatus }} </li>   
              </div>

  </body>
</template>

<script>
import InvitationService from '../services/InvitationService.js'
import TournamentService from '../services/TournamentService.js'

export default {
    name: 'invite-details',
   
   props:{
       invitationId: Number
   
    },

    data(){

       return{ 
        
        invitations: [],
        teams:[],
        players:[],
        tournaments:[],
        tournamentID: 0,

        organizerId: this.$store.state.user.id,
        // teamId: this.$store.state.activeTeam.teamId

 
       }


    },

    created(){
        // this.inviteForm.tournamentId = this.$store.state.activeTournament.tournamentId;

        TournamentService.getAllTournaments().then(response => {

            if(response.status === 200){
                this.tournaments = response.data
            }
        })

        TournamentService.getAllTeams().then(response => {

                if(response.status === 200){
                    this.teams = response.data 
                }
            })

        InvitationService.sentInviteByOrganizerId(this.organizerId).then(response => {

            if(response.status == 200){
                this.invitations = response.data

                
            }
        })

        TournamentService.getUserPlayerID(this.$store.state.user.id).then((response) => {
            if (response.status == 200) {
                if (response.data.playerId != 0) {
                    this.$store.commit("SET_ACTIVE_PLAYER", response.data);
                    this.getPlayerTeam(response.data.playerId);
                }
            } else {
              let blankPlayer = {
                playerName: '',
                playerId: 0,
                userId: this.$store.state.user.id
              }
              this.$store.commit("SET_ACTIVE_PLAYER", blankPlayer)
            }
        })

        TournamentService.getParticipantsInTournament(this.tournamentID).then(response => {

            if(response.status === 200){
                this.teams = response.data
            }
        })

        InvitationService.getInviteByTeamId(this.teamId).then(response => {

            if(response.status === 200){
                this.invitations = response.data;
            }
        })

        
    },

methods: {

     getPlayerTeam(playerId) {
      TournamentService.getTeamOfPlayer(playerId).then((response) => {
                if (response.status == 200) {
                    this.$store.commit("SET_ACTIVE_TEAM", response.data)
                }
            })
    },

//get team by tourn id, get invite by team id using list of teams in tournament
    getTeamsByTournamentId(){
        TournamentService.getParticipantsInTournament(this.tournamentID).then((response) => {
            if(response.status === 200){
                response.data.forEach(element => {
                    this.teams.push(element.teamName)
                });
                this.teams = response.data;
            }
        }
        )

    },

    getInviteByTournamentId() {
        InvitationService.getInviteByTournamentId(this.tournamentID).then((response) => {
            if (response.status == 200) {
                response.data.forEach(element => {
                    this.teams.push(element.teamName)
                    this.tournaments.push(element.tournamentName)
                    this.players.push(element.playerName)
                    this.invites.push(element.inviteStatus)
                });
                    this.invitation.invitationId = response.data.invitationId;
                    this.invitation.inviteStatus = response.data.status;
                    this.teams = response.data.teams
                
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

    },
}
</script>

<style>
.inv{
    display: flex;
    flex-direction: row;
    justify-content: center;
}
</style>