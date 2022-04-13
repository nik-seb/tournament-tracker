package com.techelevator.controller;

import com.techelevator.dao.SportsDao;
import com.techelevator.model.Sports;

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
public class SportsController {

    private final SportsDao sportsDao;

    public SportsController(SportsDao sportsDao) { this.sportsDao = sportsDao; }



    @GetMapping("/sports/{id}")
    public Sports getSport(@PathVariable int sportId) throws InterruptedException {

        Sports result = sportsDao.getSport(sportId);
        if (result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Sport found with that id. ");
        } else {
            return result;
        }
    }


    @GetMapping("/sports")
    public List<Sports> getAllSports() throws InterruptedException {
        return sportsDao.getAllSports();
    }


    @RequestMapping(path = "/sports", method = RequestMethod.POST)
    public Sports postSport(@RequestBody Sports newSport) {
        return sportsDao.createSport(newSport);
    }



    @RequestMapping(path = "/sports/{id}", method = RequestMethod.PUT)
    public Sports putSport(@PathVariable ("id") int sportId, @RequestBody Sports updatedSport) {

        if (sportsDao.updateSport(sportId) != null) {
            return updatedSport;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sport not found to update.");
        }
    }


    @DeleteMapping("/sports/{id}")
    public void deleteSport(@PathVariable int sportId) {
        if (!sportsDao.deleteSport(sportId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sport not found to delete.");
        }

    }

}
