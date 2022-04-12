package com.techelevator.dao;

import com.techelevator.model.Matches;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcMatchesDao implements MatchesDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMatchesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }


    @Override
    public Matches getMatch(int matchId) {
        Matches match = new Matches();
        String sql = "SELECT match_id, tournament_id, start_date, start_time, home_team_id, away_team_id " +
                " FROM matches " +
                " WHERE match_id = ?; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, matchId);
        if (results.next()) {
            match = mapRowToMatches(results);
        }
        return match;
    }


    @Override
    public List<Matches> getMatchesByDate(String date) {
        List<Matches> matches = new ArrayList<>();
        String sql = "SELECT match_id, tournament_id, start_date, start_time, home_team_id, away_team_id " +
                " FROM matches " +
                " WHERE start_date = ?; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, date);
        while (results.next()) {
            matches.add(mapRowToMatches(results));
        }
        return matches;
    }

    @Override
    public List<Matches> getMatchesByTournament(String tournamentId) {
        List<Matches> matches = new ArrayList<>();
        String sql = "SELECT match_id, tournament_id, start_date, start_time, home_team_id, away_team_id " +
                " FROM matches " +
                " WHERE tournament_id = ?; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tournamentId);
        while (results.next()) {
            matches.add(mapRowToMatches(results));
        }
        return matches;
    }

    @Override
    public Matches createMatch(Matches match) {
        String sql = "INSERT INTO matches (tournament_id, start_date, start_time, home_team_id, away_team_id) " +
                " VALUES (?, ?, ?, ?,?) RETURNING match_id;";
        int newMatchId = jdbcTemplate.queryForObject(sql, int.class,
                match.getTournamentId(), match.getDate(), match.getStartTime(), match.getHomeTeamId(), match.getAwayTeamId());
        Matches newMatch = getMatch(newMatchId);
        return newMatch;
    }

    @Override
    public void updateMatch(Matches match) {
        String sql = "UPDATE matches " +
                " SET tournament_id = ?, " +
                " start_date = ?, " +
                " start_time = ?, " +
                " home_team_id = ?, " +
                " away_team_id = ? " +
                " WHERE match_id = ?;";
        jdbcTemplate.update(sql, match.getTournamentId(), match.getDate(), match.getStartTime(), match.getHomeTeamId(), match.getAwayTeamId());

    }

    @Override
    public void deleteMatch(int matchId) {
        String sql = "DELETE FROM matches WHERE match_id = ?;";
        jdbcTemplate.update(sql, matchId);

    }

    private Matches mapRowToMatches(SqlRowSet results) {
        Matches match = new Matches();
        match.setMatchId(results.getInt("match_id"));
        match.setTournamentId(results.getInt("tournament_id"));
        match.setDate(results.getString("start_date"));
        match.setStartTime(results.getString("start_time"));
        match.setHomeTeamId(results.getInt("home_team_id"));
        match.setAwayTeamId(results.getInt("away_team_id"));
        return match;
    }

}
