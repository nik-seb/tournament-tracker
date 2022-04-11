import axios from 'axios';

export default {

    //TO-DO: coordinate with backend to get actual endpoints
  getSportsList() {
      return axios.get('/sports'); 
  },

  createTournament(tournament) {
    return axios.post('/tournaments', tournament);
  }

}
