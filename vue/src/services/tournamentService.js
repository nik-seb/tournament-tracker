import axios from 'axios';

export default {

    //TO-DO: coordinate with backend to get actual endpoints
  getSportsList() {
      return axios.get('/sports'); 
  },

  createSport(sportName) {
    return axios.post('/sports', sportName);
  },

  createTournament(tournament) {
    return axios.post('/tournaments', tournament);
  },

  getTournamentDetails(tournamentID) {
      return axios.get(`/tournaments/${tournamentID}`);
  }

}
