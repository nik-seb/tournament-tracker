import axios from 'axios';

export default {

    //TO-DO: coordinate with backend to get actual endpoints
  getSportsList() {
      return axios.get('/sports'); 
  },

  createSport(sportName) {
    return axios.post('/sports', sportName);
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

  getParticipantsInTournament() {

  }

}
