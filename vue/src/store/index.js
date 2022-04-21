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
      tournamentName: '',
      startDate: '',
      endDate: '',
      sportId: '',
      numOfTeams: '',
      description: '',
      tournamentId: null
    },
    activePlayer: {
      playerName: '',
<<<<<<< HEAD
      playerId: 0,
      userId: 0
=======
      playerId: 0
>>>>>>> 364b46a756a8732fdfae241785643f286bf52daa
    },
    activeTeam: {
      teamName: '',
      teamId: 0,
      teamSize: 1
    },
    holidays: [],

    teamList:[
      {
        teamName: "test team1",
        teamSize: 10,
        teamId: 1
      },
      {
        teamName: "test team2",
        teamSize: 10,
        teamId: 2
      },
      {
        teamName: "test team3",
        teamSize: 10,
        teamId: 3
      },
      {
        teamName: "test team4",
        teamSize: 10,
        teamId: 4
      }
    ],

    sportList: [
    ],

    matchesList: [
      {
      }
      
    ],

    tournamentList: [
      {
        name: 'Cool tournament',
        startDate: '1990-04-05',
        endDate: '1999-08-09',
        sportId: '5',
        numOfTeams: '99',   
        id: 1
      },
      {
        name: 'Nifty',
        startDate: '1999-03-02',
        endDate: '2000-06-05',
        sportId: '2',
        numOfTeams: '7',   
        id: 2
      },

    ],
     // everything below this line may be junk

        invitationList:[

          {
            invitationId: 0,
            tournamentId: 12,
            teamId: 12,
            organizerId: 12,
            invitationStatus: 'ACCEPTED'
          },
          {
            invitationId: 1,
            tournamentId: 11,
            teamId: 11,
            organizerId: 11,
            invitationStatus: 'PENDING'
          },
          {
            invitationId: 2,
            tournamentId: 13,
            teamId: 13,
            organizerId: 13,
            invitationStatus: 'REJECTED'
          }

        ],

  },
 
  getters:{
    userRole(state){
      return state.user.role === 'ROLE_HOST'
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
    SET_ACTIVE_PLAYER(state, player) {
      state.activePlayer = player;
    },
    SET_ACTIVE_TEAM(state, team) {
      state.activeTeam = team;
    },
    SET_SPORT_LIST(state, list) {
      state.sportList = list;
    },
    ADD_SPORT_TO_LIST(state, sport) {
      state.sportList.push(sport); 
    },
    ADD_TOURN_TO_LIST(state, tourn) {
      state.tournamentList.push(tourn);
    },
    SAVE_FORM(state, form) {
      state.inviteForm = form;
    },

    SET_TEAM_LIST(state, team){
      state.teamList = team;
    },

    SET_HOLIDAYS(state, holidays) {
      state.holidays = holidays;
    },

    SET_STATUS(state, status){
      state.invitationList = status;
    }
  }
})
