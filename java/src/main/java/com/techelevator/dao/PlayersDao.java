package com.techelevator.dao;

import com.techelevator.model.Players;
import java.util.List;

public interface PlayersDao {


    List<Players> listAllPlayers();
    Players getPlayerById(int playerId);
<<<<<<< HEAD

    List<Players> getPlayerByTeamId(int playerId);

=======
>>>>>>> 22d0f736014ae5e12b4f589ab8230e9090195707
    Players getPlayerByUserId(int userId);
    Players getPlayerName(int playerId);
    Players createPlayer(Players player);

    // Players updatePlayer(Player updatedPlayer);
    Players updatePlayer(int playerId);
    boolean deletePlayer(int playerId);
    List<Players> getPlayerByTeam(int teamId);

}
