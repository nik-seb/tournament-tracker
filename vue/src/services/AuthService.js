import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user)
  },

  register(user) {
    return axios.post('/register', user)
  },

  account(user){
    return axios.put(`/account/${user.id}`, user)
  }
}
