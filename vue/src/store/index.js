import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));




if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({

  state: {
    token: currentToken || '',
    user: currentUser || {},
    
    activeTournament: {
      name: '',
      startDate: '',
      endDate: '',
      sportId: '',
      numOfTeams: '',
      id: null
    },

    sportList: [],
    tournamentList: []

  },
    tournamentTestData:{
      name: '',
      startDate: '',
      endDate: '',
      sportId: '',
      numOfTeams: '',
    },

  getters:{
    userRole(state){
      return state.user.authorities[0].name === 'ROLE_HOST'
    },

  },
  

  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },

    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_ACTIVE_TOURNAMENT(state, tournament) {
      state.activeTournament = tournament;
    },
    SET_SPORT_LIST(state, list) {
      state.sportList = list;
    },
    ADD_SPORT_TO_LIST(state, sport) {
      state.sportList.push(sport); // should be a full sport object with name and ID
    },
    ADD_TOURN_TO_LIST(state, tourn) {
      state.tournamentList.push(tourn);
    }
  }
})
