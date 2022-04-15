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
    return axios.post('/tournaments{id}', tournament);
  },

  getTournamentDetails(tournamentID) {
      return axios.get(`/tournaments/${tournamentID}`);
  },

  getParticipantsInTournament() {

  }

}
