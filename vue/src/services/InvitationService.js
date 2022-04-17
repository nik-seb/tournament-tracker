import axios from "axios";

export default {

    createInvite(invitation){
        return axios.post('/invitations', invitation);
    },

    sentInviteByOrganizerId(organizerId){
        return axios.get(`/invitations/organizer/${organizerId}`);
    }



    




}