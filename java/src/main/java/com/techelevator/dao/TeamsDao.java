package com.techelevator.dao;

import com.techelevator.model.Teams;
import java.util.List;


public interface TeamsDao {


    List<Teams> listAllTeams();
    Teams getTeamById(int teamId);
    Teams getTeamSize(int teamSize);
    Teams createTeam(Teams team);
    Teams updateTeam(int teamId);
    boolean deleteTeam(int teamId);
    List<Teams> getTeamsByTournamentId(int id);

}
