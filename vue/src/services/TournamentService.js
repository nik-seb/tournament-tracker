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
  
  modifyTournament(tournament) {
    return axios.put(`/tournaments/${tournament.tournamentId}`, tournament);
  },

  getTournamentDetails(tournamentID) {
      return axios.get(`/tournaments/${tournamentID}`);
  },

  getTournamentsBySportId(sportID) {
    return axios.get(`/tournaments/sport/${sportID}`)
  },

  createBracketForTournament(tournamentID) {
    return axios.post(`/tournaments/${tournamentID}/bracket`);
  },

  createMatchesForNextRound(tournamentID, roundNumber) {
    return axios.put(`/tournaments/${tournamentID}/bracket/${roundNumber}`);
  },

  getMatchesByTournamentId(tournamentID) {
    return axios.get(`/tournaments/${tournamentID}/matches`);
  },

  updateMatch(match) {
    return axios.put(`/matches/${match.matchId}`, match);
  },

  updateMatchWinner(match) {
    return axios.put(`/matches/${match.matchId}/winner`, match);
  },

  getMatchByMatchId(matchId) {
    return axios.get(`/matches/${matchId}`)
  },

  addParticipantToTournament(tournamentID, team) {
    return axios.post(`/tournaments/${tournamentID}/teams`, team);
  },

  getParticipantsInTournament(tournamentID) {
      return axios.get(`/tournaments/${tournamentID}/teams`);
  },

  getTeamOfPlayer(playerID) {
    return axios.get(`/players/${playerID}/team`);
  },

  getTeamByTeamId(teamID) {
    return axios.get(`/teams/${teamID}`);
  },

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
  },

  getAllTeams(){
    return axios.get('/teams');
  },

  getAllLocations(){
    return axios.get('/locations');
  },

  addLocation(location) {
    return axios.post('/locations', location);
  }

}
