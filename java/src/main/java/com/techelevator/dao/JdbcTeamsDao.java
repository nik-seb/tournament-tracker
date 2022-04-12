package com.techelevator.dao;

import com.techelevator.model.Teams;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.security.Principal;


@Component
public class JdbcTeamsDao implements TeamsDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTeamsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Teams> listAllTeams() {
        List<Teams> teams = new ArrayList<>();
        String sql = "SELECT * " +
                     "FROM teams; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            teams.add(mapRowToTeams(results));

        }
        return teams;
    }



    @Override
    public Teams getTeamById(int teamId) {
        Teams team = new Teams();
        String sql = "SELECT team_id " +
                     "FROM teams " +
                     "WHERE team_id = ?; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, teamId);
        if (results.next()) {
            team = mapRowToTeams(results);

        }
        return team;
    }




    @Override
    public Teams getTeamSize(int teamSize) {
        Teams team = new Teams();
        String sql = "SELECT team_size " +
                     "FROM teams " +
                     "WHERE team_size = ?; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, teamSize);
        if (results.next()) {
            team = mapRowToTeams(results);

        }
        return team;
    }






    private Teams mapRowToTeams(SqlRowSet results) {
        Teams team = new Teams();
        team.setTeamId(results.getInt("team_id"));
        team.setTeamSize(results.getInt("team_size"));
        return team;
    }


}
