import axios from "axios";

export default {

    createInvite(invitation){
        return axios.post('/invitations', invitation);
    },

    getInviteByOrganizerId(invitation){
        return axios.get(`/invitations/teams/{}`,invitation)
    }

    




}