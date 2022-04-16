import axios from 'axios';

export default {

  getSportsList() {
      return axios.get('/sports'); 
  },

  createSport(sport) {
    return axios.post('/sports', sport);
  },

  getSportById(sportID) {
    return axios.get(`/sports/${sportID}`);
  },

  getAllTournaments() {
    return axios.get('/tournaments');
  },

  createTournament(tournament) {
    return axios.post('/tournaments', tournament);
  },

  getTournamentDetails(tournamentID) {
      return axios.get(`/tournaments/${tournamentID}`);
  },

  addParticipantToTournament(tournamentID, team) {
    return axios.post(`tournaments/${tournamentID}/teams`, team);
  },

  getParticipantsInTournament(tournamentID) {
      return axios.get(`tournaments/${tournamentID}/teams`);
  },

  getTeamOfPlayer(playerID) {
    return axios.get(`/players/${playerID}/team`);
  },

  //get the player associated with the input user
  getUserPlayerID(userID) {
    return axios.get(`/players/user/${userID}`);
  },

  createNewPlayer(player) {
    return axios.post('/players', player);
  },

  createNewTeam(team) {
    return axios.post('/teams', team);
  },

  addPlayerToTeam(teamID, player) {
    return axios.post(`/teams/${teamID}/player`, player);
  }

}
