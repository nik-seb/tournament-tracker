package com.techelevator.controller;

import com.techelevator.dao.TournamentDao;
import com.techelevator.exception.AuthorizationException;
import com.techelevator.exception.TournamentNotFoundException;
import com.techelevator.model.Tournament;
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
import java.util.List;


@RestController
@CrossOrigin

public class TournamentController {

    private final TournamentDao tournamentDao;



    public TournamentController(TournamentDao tournamentDao) {
        this.tournamentDao = tournamentDao;
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
        public Tournament putTournament(@PathVariable("id") int tournamentId, @RequestBody Tournament updatedTournament) throws TournamentNotFoundException {

            if (tournamentDao.updateTournament(tournamentId) != null) {
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

    }



