package com.techelevator.controller;

import com.techelevator.dao.TournamentDao;
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
import java.util.List;


@RestController
@CrossOrigin

public class TournamentController {

    private final TournamentDao tournamentDao;



    public TournamentController(TournamentDao tournamentDao) {
        this.tournamentDao = tournamentDao;
    }


    @GetMapping("/tournament")
    public List<Tournament> getAllTournaments() throws InterruptedException {
        return tournamentDao.getAllTournaments();
    }


    @GetMapping("/tournaments/{id}")
    public Tournament getTournamentById(@PathVariable int tournamentId) throws InterruptedException {

        Tournament result = tournamentDao.getTournamentById(tournamentId);
        if (result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Tournament with that id. ");
        } else {
            return result;
        }

    }


        @RequestMapping(path = "/tournaments", method = RequestMethod.POST)
        public Tournament postTournament(@RequestBody Tournament newTournament) {
            return tournamentDao.create(newTournament);
        }




        @RequestMapping(path = "/tournaments/{id}", method = RequestMethod.PUT)
        public Tournament putTournament(@PathVariable("id") int tournamentId, @RequestBody Tournament updatedTournament) {

            if (tournamentDao.updateTournament(tournamentId) != null) {
                return updatedTournament;
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tournament not found to update.");
            }
        }

        @DeleteMapping("/tournaments/{id}")
        public void deleteTournament ( @PathVariable int tournamentId) {
            if (!tournamentDao.deleteTournament(tournamentId)) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tournament not found to delete.");
            }

        }

    }



