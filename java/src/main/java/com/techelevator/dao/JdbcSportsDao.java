package com.techelevator.dao;

import com.techelevator.model.Matches;
import com.techelevator.model.Sports;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcSportsDao implements SportsDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcSportsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Sports getSport(int sportId) {
        Sports sport = new Sports();
        String sql = "SELECT sport_id, sport_name " +
                " FROM sports " +
                " WHERE sport_id = ?; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, sportId);
        if (results.next()) {
            sport = mapRowToSports(results);
        }
        return sport;
    }


    @Override
    public List<Sports> getAllSports(String sportName) {
        List<Sports> sports = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT sport_name " +
                " FROM sports; ");
        while (results.next()) {
            sports.add(mapRowToSports(results));
        }
        return sports;
    }

    @Override
    public Sports createSport(Sports sport) {
        String sql = "INSERT INTO sports (sport_name) " +
                " VALUES (?) RETURNING sport_id;";
        int newSportId = jdbcTemplate.queryForObject(sql, int.class,
                sport.getSportName());
        Sports newSport = getSport(newSportId);
        return newSport;
    }

    @Override
    public void updateSport(Sports sport) {
        String sql = "UPDATE sports " +
                " SET sport_name = ? " +
                " WHERE sport_id = ?;";
        jdbcTemplate.update(sql, sport.getSportName());

    }

    @Override
    public void deleteSport(int sportId) {
        String sql = "DELETE FROM sports WHERE sport_id = ?;";
        jdbcTemplate.update(sql, sportId);
    }

    private Sports mapRowToSports(SqlRowSet results) {
        Sports sport = new Sports();
//     not sure if this line needed here*   int sportId = results.getInt("sport_id");
        sport.setSportId(results.getInt("sport_id"));
        sport.setSportName(results.getString("sport_name"));
        return sport;
    }
}
