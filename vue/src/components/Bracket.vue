<template>
  <div>
      <h3>Bracket</h3>
      <p>Schedule TBD</p>
      <img src="../assets/tournament_picture.jpg" alt="example of tournament picture">
  </div>
</template>

<script>
export default {
    name: 'bracket',
    props: {
        tournamentID: Number
    },
    data () {
        return {
            tournament: {
                name: 'Cool tournament',
                startDate: '1990-04-05',
                endDate: '1999-08-09',
                sportId: '5',
                numOfTeams: '99',   
                id: 1
            },
            teams: [
                {
                    teamId: 1,
                    teamName: 'Owls'
                },
                {
                    teamId: 2,
                    teamName: 'Eagles'
                },
                {
                    teamId: 3,
                    teamName: 'Falcons'
                },
                {
                    teamId: 4,
                    teamName: 'Larks'
                },
                {
                    teamId: 5,
                    teamName: 'Toucans'
                },
                {
                    teamId: 6,
                    teamName: 'Finches'
                },
                {
                    teamId: 7,
                    teamName: 'Blackbirds'
                }
            ],
            matches: [
                {
                    tournamentId: 1,
                    startDate: '',
                    startTime: '',
                    homeTeamId: '',
                    awayTeamId: '',
                    locationId: '',
                    winningTeamId: null
                }
            ]
        }
    }
}
</script>

<style>
    img {
        width: 500px;
    }
</style>