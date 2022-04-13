package com.techelevator.controller;

import com.techelevator.dao.MatchesDao;
import com.techelevator.model.Matches;
import com.techelevator.model.Players;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
public class MatchesController {


    private final MatchesDao matchesDao;

    public MatchesController(MatchesDao matchesDao) { this.matchesDao = matchesDao; }


//    @GetMapping("/matches")
//    public List<Matches> getMatchesByDate() throws InterruptedException {
//        return matchesDao.getMatchesByDate();
//    }
    // to do

    @GetMapping("/matches/{tournamentId}")
    public List<Matches> getMatchesByTournament(@PathVariable int tournamentId) throws InterruptedException {
        return matchesDao.getMatchesByTournament(tournamentId);
    }

    @GetMapping("/matches/{id}")
    public Matches getMatch(@PathVariable int matchId) throws InterruptedException {

        Matches result = matchesDao.getMatch(matchId);
        if (result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Match found with that id. ");
        } else {
            return result;
    }

}

    @RequestMapping(path = "/matches", method = RequestMethod.POST)
    public Matches postMatch(@RequestBody Matches newMatch) {
        return matchesDao.createMatch(newMatch);
    }


    @RequestMapping(path = "/matches/{id}", method = RequestMethod.PUT)
    public Matches putMatch(@PathVariable ("id") int matchId, @RequestBody Matches updatedMatch) {

        if (matchesDao.updateMatch(matchId) != null) {
            return updatedMatch;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Matches not found to update.");
    }

}


    @DeleteMapping("/matches/{id}")
    public void deleteMatch(@PathVariable int matchId) {
        if (!matchesDao.deleteMatch(matchId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Matches not found to delete.");
        }

    }




}
