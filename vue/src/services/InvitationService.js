import axios from "axios";

export default {

    createInvite(invitation){
        return axios.post('/invitations', invitation);
    },

    sentInviteByOrganizerId(organizerId){
        return axios.get(`/invitations/organizer/${organizerId}`);
    },

  
    getInviteList() {
        return axios.get('/invitations');
    },

    getInviteByStatus(invitationStatus) {
        return axios.get(`/invitations/${invitationStatus}`);
    },

    getInvitationByTeamId(teamId) {
        return axios.get(`/invitations/${teamId}`);
    },

    getInviteByOrganizer(organizerId) {
        return axios.get(`/invitations/${organizerId}`);
    },

    updateInvitationStatus(invitation) {
        return axios.put(`/invitations/status/`, invitation);
    }
    
}