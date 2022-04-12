package com.techelevator.dao;

import com.techelevator.model.Matches;
import com.techelevator.model.Players;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.security.Principal;


@Component
public class JdbcPlayersDao implements PlayersDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcPlayersDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public Players getPlayerById(int playerId) {
        Players player = new Players();
        String sql = "SELECT player_id " +
                     "FROM players " +
                     "WHERE player_id = ?; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, playerId);
            if (results.next()) {
                player = mapRowToPlayers(results);

    }
            return player;
}




    @Override
    public Players getPlayerByUserId(int userId) {
        Players player = new Players();
        String sql = "SELECT user_id " +
                     "FROM players " +
                     "WHERE user_id = ?; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            player = mapRowToPlayers(results);

        }
            return player;
    }




   @Override
    public Players getPlayerByPlayerName(String playerName) {

        Players player = new Players();
        String sql = "SELECT player_name " +
                     "FROM players " +
                     "WHERE player_name = ?; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, playerName);
            if (results.next()) {
            player = mapRowToPlayers(results);

        }
        return player;
    }


    @Override
    public List<Players> listAllPlayers() {
        List<Players> players = new ArrayList<>();
        String sql = "SELECT * " +
                     "FROM players; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
            players.add(mapRowToPlayers(results));

        }
        return players;
    }



    @Override
    public Players createPlayer(Players player) {
        String sql = "INSERT INTO players (user_id, player_name) VALUES (?, ?) RETURNING player_id;";
        int newPlayerId = jdbcTemplate.queryForObject(sql, int.class,  player.getUserId(),  player.getPlayerName());
        Players newPlayer = getPlayerById(newPlayerId);
        return newPlayer;

    }

    @Override
    public void updatePlayer(Players player) {
        String sql = "UPDATE players " +
                " SET user_id = ?, " +
                " player_name = ?;";
        jdbcTemplate.update(sql, player.getUserId(), player.getPlayerName());

    }

        @Override
        public void deletePlayer(int playerId){
            String sql = "DELETE FROM players WHERE player_id = ?;";
            jdbcTemplate.update(sql, playerId);

        }

    private Players mapRowToPlayers(SqlRowSet results) {
        Players player = new Players();
        player.setPlayerId(results.getInt("player_id"));
        player.setUserId(results.getInt("user_id"));
        player.setPlayerName(results.getString("player_name"));
        return player;
    }


}
