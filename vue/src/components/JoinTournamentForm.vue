<template>
    <div>
        <form id="register-user" v-if="player.playerId == 0 || team.teamId == 0" v-on:submit.prevent="createPlayerAndTeam()">
            <p>You haven't been recorded as a player on a team yet. Please set your player and team name before joining the tournament.</p>
            <label for="player-name">Set your player name: </label>
            <input type="text" id="player-name" value="player-name" v-model="player.playerName">
            <label for="team-name">Set your team name: </label>
            <input type="text" id="team-name" value="team-name" v-model="team.teamName">
            <!-- for now, we are assuming player name = team name and updating tables accordingly
            will later add team name and location to use when determining match location according to home/away team
            -->
            <input type="submit" value="Register as new player.">
        </form>
        <!-- TO-DO: fix: even if you get a 500 response from server, this still switches on and implies registration was successful -->
        <form id ="join-form" v-if="player.playerId != 0 && team.teamId != 0" v-on:submit.prevent="joinTournament()">
            <p> You are registered as player {{player.playerName}} on team {{team.teamName}}. Would you like to join this tournament?</p>
            <input type="submit" value="Join the tournament!">
        </form>
    </div>
</template>

<script>
import TournamentService from "@/services/TournamentService.js";
export default {
    name: 'join-tournament-form',
    data () {
        return {
            player: this.$store.state.activePlayer,
            team: this.$store.state.activeTeam,
            tournament: this.$store.state.activeTournament
        }
    },
    methods: {
        createPlayerAndTeam() {
            TournamentService.createNewPlayer(this.player).then((response) => {
                if (response.status == 200) {
                    this.player.playerId = response.data.playerId;
                    console.log(response.data)
                    TournamentService.createNewTeam(this.team).then((response) => {
                    if (response.status == 200) {
                        this.team.teamId = response.data.teamId;
                        console.log(response.data)
                        TournamentService.addPlayerToTeam(this.team.teamId, this.player).then((response) => {
                            // will need to manually increment team size when we fully implement teams
                            if (response.status == 200) {
                                alert("You've been registered successfully");
                            } else {
                                alert("Something went wrong. Please try again.")
                            }
                        })
                    }
                    });
                }
            });
        },
        joinTournament () {
            TournamentService.addParticipantToTournament(this.tournament.tournamentId, this.team).then((response) => {
                if (response.status == 200) {
                    alert("You have joined the tournament!")
                    this.tournament.numOfTeams++;
                    TournamentService.modifyTournament(this.tournament).then((response) => {
                        console.log(response);
                    })
                }
            })
        }
    }
}
</script>

<style>

</style>