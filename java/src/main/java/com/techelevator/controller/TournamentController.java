package com.techelevator.controller;

import com.techelevator.dao.MatchesDao;
import com.techelevator.dao.TeamsDao;
import com.techelevator.dao.TournamentDao;
import com.techelevator.exception.AuthorizationException;
import com.techelevator.exception.MatchNotFoundException;
import com.techelevator.exception.TeamNotFoundException;
import com.techelevator.exception.TournamentNotFoundException;
import com.techelevator.model.Matches;
import com.techelevator.model.Teams;
import com.techelevator.model.Tournament;
import com.techelevator.services.TournamentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin

public class TournamentController {

    private final TournamentDao tournamentDao;
    private final MatchesDao matchesDao;
    private final TeamsDao teamsDao;
    private final TournamentService tournamentService;



    public TournamentController(TournamentDao tournamentDao, MatchesDao matchesDao, TeamsDao teamsDao, TournamentService tournamentService) {
        this.tournamentDao = tournamentDao;
        this.matchesDao = matchesDao;
        this.teamsDao = teamsDao;
        this.tournamentService = tournamentService;
    }

    // get teams by tournament ID
    @RequestMapping(path = "/tournaments/{id}/teams", method = RequestMethod.GET)
    public List<Teams> getTournamentTeams(@PathVariable ("id") int tournamentId){

        return teamsDao.getTeamsByTournamentId(tournamentId);
    }
    @RequestMapping(path = "tournaments/{id}/matches", method = RequestMethod.GET)
    public List<Matches> getTournamentMatches(@PathVariable ("id") int tournamentId){
        return matchesDao.getMatchesByTournament(tournamentId);
    }



    @RequestMapping(path = "/tournaments", method = RequestMethod.GET)
    public List<Tournament> getAllTournaments() {

        return tournamentDao.getAllTournaments();
    }


    @GetMapping("/tournaments/{id}")
    public Tournament getTournamentById(@PathVariable ("id") int tournamentId) throws TournamentNotFoundException {

        Tournament result = tournamentDao.getTournamentById(tournamentId);
        if (result == null) {
            throw new TournamentNotFoundException();
        } else {
            return result;
        }

    }


        @RequestMapping(path = "/tournaments", method = RequestMethod.POST)
        public Tournament postTournament(@RequestBody Tournament newTournament) throws TournamentNotFoundException {
            return tournamentDao.create(newTournament);
        }

        @RequestMapping(path = "/tournaments/{id}", method = RequestMethod.PUT)
        public Tournament putTournament(@RequestBody Tournament updatedTournament, @PathVariable("id") int tournamentId) throws TournamentNotFoundException {

            if (tournamentDao.updateTournament(updatedTournament, tournamentId) != null) {
                return updatedTournament;
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tournament not found to update.");
        }
    }

        @DeleteMapping("/tournaments/{id}")
        public void deleteTournament ( @PathVariable ("id") int tournamentId) throws TournamentNotFoundException {
            if (!tournamentDao.deleteTournament(tournamentId)) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tournament not found to delete.");
            }

        }

        @RequestMapping(path = "tournaments/{id}/teams", method = RequestMethod.POST)
        public void addTeamsToTournament(@PathVariable ("id") int tournamentId, @RequestBody Teams teams)
                                        throws TournamentNotFoundException, TeamNotFoundException {

            tournamentDao.addTeamsToTournaments(teams, tournamentId);
        }
        @RequestMapping(path = "tournaments/{id}/bracket", method = RequestMethod.POST)
        public void createBracket(@PathVariable ("id") int tournamentId){
            List<Teams> teamsList = new ArrayList<>();
            Teams one = new Teams(1, "one", 4);
            Teams two = new Teams(2, "two", 4);
            Teams three = new Teams(3, "three", 4);
            Teams four = new Teams(4, "four", 4);
            Teams five = new Teams(5, "five", 4);
            Teams six = new Teams(6, "six", 4);
            Teams seven = new Teams(7, "seven", 4);
            Teams eight = new Teams(8, "eight", 4);
            Teams nine = new Teams(9, "nine", 4);
            Teams ten = new Teams(10, "ten", 4);
            Teams eleven = new Teams(11, "eleven", 4);
            Teams twelve = new Teams(12, "twelve", 4);

            teamsList.add(one);
            teamsList.add(two);
            teamsList.add(three);
            teamsList.add(four);
            teamsList.add(five);
            teamsList.add(six);
            teamsList.add(seven);
            teamsList.add(eight);
            teamsList.add(nine);
            teamsList.add(ten);
            teamsList.add(eleven);
            teamsList.add(twelve);
//            List<Teams> teams1 = teamsDao.getTeamsByTournamentId(tournamentId);
            tournamentService.generateBracket(teamsList, tournamentId);
        }




    }



