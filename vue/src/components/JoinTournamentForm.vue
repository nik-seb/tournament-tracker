<template>
    <div>
        <form id="register-user" v-if="playerId == 0" v-on:submit.prevent="createPlayerAndTeam()">
            <p>You haven't been recorded as a player yet. Please set your player and team name before joining the tournament.</p>
            <label for="player-name">Set your player name: </label>
            <input type="text" id="player-name" value="player-name" v-model="player.playerName">
            <label for="team-name">Set your team name: </label>
            <input type="text" id="team-name" value="team-name" v-model="team.teamName">
            <!-- for now, we are assuming player name = team name and updating tables accordingly
            will later add team name and location to use when determining match location according to home/away team
            -->
            <input type="submit" value="Register as new player.">
        </form>
        <form id ="join-form" v-if="playerId != 0">
            <p> You are registered as player {{player.playerName}} on team {{team.teamName}}. Would you like to join this tournament?</p>
            <input type="submit" value="Join the tournament!">
        </form>
    </div>
</template>

<script>
import TournamentService from "@/services/TournamentService.js";
export default {
    name: 'join-tournament-form',
    props: {
        tournamentID: Number
    },
    data () {
        return {
            player: {
                playerName: '',
                playerId: 0,
                userId: this.$store.state.user.id
            },
            team: {
                teamName: '',
                teamId: 0,
                teamSize: 1
            }
        }
    },
    created() {
        TournamentService.getUserPlayerID(this.player.userId).then((response) => {
            if (response.status == 200) {
                if (response.data.playerId != 0) {
                    this.player = response.data;
                    this.getPlayerTeam();
                }
            }
        })
    },
    methods: {
        getPlayerTeam () {
            TournamentService.getTeamOfPlayer(this.player.playerId).then((response) => {
                if (response.status == 200) {
                    this.team = response.data;
                }
            })
        },
        createPlayerAndTeam() {
            TournamentService.createNewPlayer(this.player).then((response) => {
                if (response.status == 200) {
                    this.player.playerId = response.data.playerId;
                    TournamentService.createNewTeam(this.team).then((response) => {
                    if (response.status == 200) {
                        this.team == response.data;
                        TournamentService.addPlayerToTeam(this.team.teamId, this.player).then((response) => {
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
            TournamentService.addParticipantToTournament(this.tournamentID, this.team)
        }
    }
}
</script>

<style>

</style>