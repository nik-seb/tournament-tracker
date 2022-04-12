package com.techelevator.dao;

import com.techelevator.model.Tournament;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcTournamentDao implements TournamentDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTournamentDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Tournament create(Tournament tournament) {
        String sql = "INSERT INTO tournaments " +
                "(tournament_name, num_of_teams, start_date, end_date, sport_id) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING tournament_id;";
        int newId = jdbcTemplate.queryForObject(sql, Integer.class,
                tournament.getTournamentName(), tournament.getNumOfTeams(), tournament.getStartDate(), tournament.getEndDate(), tournament.getSportId());


        return getTournamentById(newId);
    }

    @Override
    public Tournament getTournamentById(int tournamentId) {
        String sql = "SELECT * " +
                "FROM tournaments " +
                "WHERE tournament_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, tournamentId);
        if(rowSet.next()){
            return mapRowToTourney(rowSet);
        }
        return null;
    }

    @Override
    public List<Tournament> getAllTournaments() {
        List<Tournament> tournaments = new ArrayList<>();
        String sql = "SELECT tournament_id, tournament_name, num_of_teams, start_date, end_date, sport_id " +
                "FROM tournaments;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            Tournament tournament = mapRowToTourney(results);
            tournaments.add(tournament);
        }
        return tournaments;
    }

    @Override
    public Tournament updateTournament(int tournamentId) {
        String sql = "UPDATE tournaments " +
                "SET tournament_id = ?, " +
                "tournament_name = ?, " +
                "num_of_teams = ?, " +
                "start_date = ?, " +
                "end_date = ?, " +
                "sport_id = ? " +
                "WHERE tournament_id = ?;";

        Tournament tournament = new Tournament();
        jdbcTemplate.update(sql, tournament.getTournamentId(), tournament.getTournamentName(), tournament.getNumOfTeams(),
                tournament.getStartDate(), tournament.getEndDate(), tournament.getSportId(), tournamentId);
        return getTournamentById(tournamentId);
    }


    @Override
    public boolean deleteTournament(int tournamentId) {
        String sql = "DELETE FROM tournaments WHERE tournament_id = ?;";
        jdbcTemplate.update(sql, tournamentId);
       if (getTournamentById(tournamentId) == null) {
           return true;
       } else {
           return false;
       }
    }



    private Tournament mapRowToTourney(SqlRowSet row){
        Tournament tournament = new Tournament();
        tournament.setTournamentId(row.getInt("tournament_id"));
        tournament.setTournamentName(row.getString("tournament_name"));
        tournament.setStartDate(row.getString("start_date"));
        tournament.setEndDate(row.getString("end_date"));
        tournament.setSportId(row.getInt("sport_id"));
        return tournament;
    }
}
