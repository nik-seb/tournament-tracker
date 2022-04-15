package com.techelevator.dao;

import com.techelevator.model.Teams;
import java.util.List;


public interface TeamsDao {


<<<<<<< HEAD
        List<Teams> listAllTeams();
        List<Teams> getTeamsByTournamentId();

        Teams getTeamById(int teamId);

        List<Teams> getTeamsBySize(int teamSize);

        Teams createTeam(Teams team);

        //boolean updateTeam(Teams team);

        void deleteTeam(int teamId);
=======
      List<Teams> listAllTeams();
      Teams getTeamById(int teamId);
      Teams getTeamSize(int teamSize);
      Teams createTeam(Teams team);
      Teams updateTeam(int teamId);
      boolean deleteTeam(int teamId);
<<<<<<< HEAD
>>>>>>> 22d0f736014ae5e12b4f589ab8230e9090195707
=======
      List<Teams> getTeamsByTournamentId(int id);
>>>>>>> 61510dee03bd11158fbfeaa1ce62739c0a0e2d81

}
