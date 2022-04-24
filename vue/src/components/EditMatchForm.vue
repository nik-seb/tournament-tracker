<template>
    <div id="main-match-form" v-if="match.winningTeamId == 0">
        <form v-on:submit.prevent="submitForm()" >
            <p>{{match.homeTeamName}} vs {{match.awayTeamName}} </p>

            <label for="date">Select a date for this match: </label>
            <input type="date" v-bind:id="'date' + match.matchId" value="date" v-model="match.startDate">
            <div id="isHoliday" v-if="dateIsAHoliday">{{currentHoliday}} is observed on this day.</div>

            <label for="date">Select a time for this match: </label>
            <input type="time" v-bind:id="'time' + match.matchId" value="time" v-model="match.startTime">

            <label for="location">Select a location for this match: </label>
            <select id="location" name="location" v-model="match.locationId">
              <option value='' disabled></option>
              <option v-for="location in locations" v-bind:key="location.locationId" v-bind:value="location.locationId">{{location.cityName}}, {{location.stateName}}</option>
              <option value='newLocation'>Add new location</option>
          </select>
          <p v-if="match.locationId == 'newLocation'">
              <label for="newLocationState">New location state</label>
              <input type="text" name="newLocationState" id="newLocationState" v-model="newLocation.stateName">
              <label for="newLocationCity">New location city</label>
              <input type="text" name="newLocationCity" id="newLocationCity" v-model="newLocation.cityName">
          </p>

            <input type="submit" value="Confirm match details">
        </form>

    </div>
</template>

<script>
import TournamentService from '@/services/TournamentService.js';

export default {
    name: 'edit-match-form',
    props: {
        Match: Object
    },
    data () {
        return {
            match: this.Match,
            locations: [],
            currentHoliday: '',
            newLocation: {
                stateName: '',
                cityName: ''
            }
        }
    },
    created() {
        TournamentService.getAllLocations().then((response) => {
            if (response.status == 200) {
                this.locations = response.data;
            }
        })
    },
    methods: {
        submitForm() {
            if (this.newLocation.stateName != '') {
                TournamentService.addLocation(this.newLocation).then((response) => {
                    if (response.status == 200) {
                        const newId = response.data.locationId;
                        this.match.locationId = newId;
                        this.saveMatch();
                        // reloads locations so new location appears in dropdown as selected
                        TournamentService.getAllLocations().then((response) => {
                            if (response.status == 200) {
                                this.locations = response.data;
                            }
                        })
                    }
                })
            } else {
                this.saveMatch();
            }
        },
        saveMatch() {
            TournamentService.updateMatch(this.match).then(response => {
                if (response.status == 200) {
                    alert('The match has been successfully updated.')
                }
            })
        }
    },
    computed: {
        dateIsAHoliday() {
            let matchingHoliday = this.$store.state.holidays.find((holiday) => {
                if (!this.match.startDate) {
                    return false;
                }
                let abbrev = holiday.date.toString().slice(5);
                let abbrev2 = this.match.startDate.toString().slice(5);
                console.log(abbrev, abbrev2)
                if (abbrev == abbrev2) {
                    this.currentHoliday = holiday.name;
                    return true;
                }
            })
            if (matchingHoliday) {
                return true;
            } else {
                return false;
            }
        }
    }
}
</script>

<style>
form{
    position: relative;
  background: black #FFFFFF;
  max-width: 360px;
  margin: 0 auto ;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
  display: flex;
  flex-direction: column;
  margin-left: 0px;
}

input {
    margin-top: 7px;
    margin-bottom: 7px;
}

#main-match-form {
    margin: 0px;
}

#isHoliday {
    background-color: goldenrod;
    color: black;
    padding: 0.15rem;
    margin-bottom: 0.15rem;
}

</style>