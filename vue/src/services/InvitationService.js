import axios from "axios";

export default {

    createInvite(invitation){
        return axios.post('/invitations', invitation);
    },

    getInviteByOrganizerId(){
        
    }

    




}