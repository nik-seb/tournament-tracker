package com.techelevator.dao;

import com.techelevator.model.Teams;
import java.util.List;


public interface TeamsDao {


        List<Teams> listAllTeams();

        Teams getTeamById(int teamId);

        List<Teams> getTeamsBySize(int teamSize);

        Teams createTeam(Teams team);

        //boolean updateTeam(Teams team);

        void deleteTeam(int teamId);

}
