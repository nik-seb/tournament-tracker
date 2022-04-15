<template>
  <div>
      <form v-on:submit.prevent="modifyTournament()">
          <label for="tournamentName">Tournament Name(modify)</label>
          <input type="text" name="tournamentName" v-model="newTournament.tournamentName">
          <label for="sportType">Sport or Game(modify)</label>
          <select id="sportType" name="sportType" v-model="newTournament.sportId">
              <option value='' disabled></option>
              <option v-for="sport in this.$store.state.sportList" v-bind:key="sport.sportId" v-bind:value="sport.sportId">{{sport.sportName}}</option>
              <option value="newSport">Add New Sport</option>
          </select>
          <p v-if="newTournament.sportId == 'newSport'">
              <label for="newSportName">New Sport Name:</label>
              <input type="text" name="newSportName" id="newSportName" v-model="newSport.sportName">
          </p>
          <label for="startDate">Start Date</label>
          <input type="date" name="startDate" v-model="newTournament.startDate">
          <label for="endDate">End Date</label>
          <input type="date" name="endDate" v-model="newTournament.endDate">
          <label for="tournamentDescription"> Description </label>
          <input type="text" placeholder="Enter a brief description pertaining to the tournament you are entering in!" v-model="newTournament.description" >
          <button id="btn" type="submit"> Modify Tournament </button>
      </form>
  </div>
</template>

<script>
import TournamentService from '@/services/TournamentService.js';
export default {
    name: 'Modify-tournament',
    data() {  return {
            modifiedTournament: {
                tournamentId: this.$store.state.activeTournament.tournamentId,
                tournamentName: this.$store.state.activeTournament.tournamentName ,
                startDate: this.$store.state.activeTournament.startDate,
                endDate: this.$store.state.activeTournament.endDate,
                sportId: this.$store.state.activeTournament.sportId,
                numOfTeams:this.$store.state.activeTournament.numOfTeams,
                description: this.$store.state.activeTournament.description
                
            },
            newSport: {
                sportName: ''
            }
        }

    },
    created(){
        if (this.$store.state.sportList.length == 0) {
            TournamentService.getSportsList().then((response) => {
                if (response.status == 200) {
                    this.$store.commit("SET_SPORT_LIST", response.data);
                }
            });
        }

    },
 methods: {
        createTournament() {
            if (this.newSport.sportName != '') {
                TournamentService.createSport(this.newSport).then((response) => {
                if (response.status == 200) {
                    this.$store.commit("ADD_SPORT_TO_LIST", response.data);
                    console.log(response.data.sportId + ' is sportid')
                    this.newTournament.sportId = Number(response.data.sportId);
                    // TO-DO: refactor the horrible thing below, too much copy-paste. be careful not to create tournament before sport id is retrieved
                    this.$store.commit("ADD_TOURN_TO_LIST", this.newTournament);
                    console.log(this.newTournament);
                    TournamentService.createTournament(this.newTournament).then((responseT) => {
                        if (responseT.status == 200) {
                            const newID = Number(responseT.data.tournamentId);
                            this.$router.push({name: 'view-tournament', params: {id: newID}});
                        } else {
                            console.log(responseT);
                        }
                    })
                }
            })
        
            } else {
                this.$store.commit("ADD_TOURN_TO_LIST", this.newTournament);
                TournamentService.createTournament(this.newTournament).then((response) => {
                    if (response.status == 200) {
                        const newID = Number(response.data.tournamentId);
                        this.$router.push({name: 'view-tournament', params: {id: newID}});
                    } else {
                        console.log(response);
                    }
                })
            }
        }
    }
}
</script>

<style scoped>
#tournament-form{
    display: flex;
    flex-direction: row;
    justify-content: center;
}
</style>