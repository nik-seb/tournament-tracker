package com.techelevator.dao;

import com.techelevator.model.Players;
import java.util.List;

public interface PlayersDao {

    List<Players> listAllPlayers();

    Players getPlayerById(int playerId);

    Players getPlayerByUserId(int userId);

    Players getPlayerByPlayerName(String playerName);


}
