package com.techelevator.controller;

import com.techelevator.dao.TeamsDao;
import com.techelevator.model.Teams;
import com.techelevator.exception.AuthorizationException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import com.techelevator.exception.TeamNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@RestController
@CrossOrigin
public class TeamsController {

    private final TeamsDao teamsDao;


    public TeamsController(TeamsDao teamsDao) { this.teamsDao = teamsDao; }


    @GetMapping("/teams")
    public List<Teams> listAllTeams() {
        return teamsDao.listAllTeams();
    }

    @GetMapping("/teams/{id}")
    public Teams getTeamById(@PathVariable int teamId) throws TeamNotFoundException {

        Teams result = teamsDao.getTeamById(teamId);
        if (result == null) {
            throw new TeamNotFoundException("No Team found with that id. ");
        } else {
            return result;
        }
    }



    @GetMapping("/teams/teamSize")
    public Teams getTeamSize(@PathVariable  int teamSize) throws TeamNotFoundException{

        Teams result = teamsDao.getTeamSize(teamSize);
        if (result == null) {
            throw new TeamNotFoundException("No Team Found with that size");
        } else {
            return result;
        }
    }




    @RequestMapping(path = "/teams", method = RequestMethod.POST)
    public Teams postTeam(@RequestBody Teams newTeam) {
        return teamsDao.createTeam(newTeam);
    }


    @RequestMapping(path = "/teams/{id}", method = RequestMethod.PUT)
    public Teams putTeam(@PathVariable ("id") int teamId, @RequestBody Teams updatedTeam) throws TeamNotFoundException {

       if (teamsDao.updateTeam(teamId) != null) {
            return updatedTeam;
        } else {
           throw new TeamNotFoundException("No Team found with that id. ");
        }
    }

    @DeleteMapping("/teams/{id}")
    public void deleteTeam(@PathVariable int teamId) throws TeamNotFoundException {
      if (!teamsDao.deleteTeam(teamId)) {
           throw new TeamNotFoundException("Team not found to delete.");
         }

     }

}

