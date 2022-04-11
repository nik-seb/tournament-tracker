package com.techelevator.model;

public class Players {


    private int playerId;
    private int userId;
    private String playerName;


    public Players () {}

    public Players(int playerId, int userId, String playerName) {
        this.playerId = playerId;
        this.userId = userId;
        this.playerName = playerName;
    }



    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


}
