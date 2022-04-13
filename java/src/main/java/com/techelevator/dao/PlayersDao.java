package com.techelevator.dao;

import com.techelevator.model.Players;
import java.util.List;

public interface PlayersDao {

    List<Players> listAllPlayers();

    Players getPlayerById(int playerId);

    List<Players> getPlayerByTeamId(int playerId);

    Players getPlayerByUserId(int userId);

    Players getPlayerByPlayerName(String playerName);

    Players createPlayer(Players player);

    void updatePlayer(Players player);

    void deletePlayer(int playerId);

}
