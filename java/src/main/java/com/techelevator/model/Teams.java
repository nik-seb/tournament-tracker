package com.techelevator.model;

public class Teams {


    private int teamId;
    private int teamSize;
    

    public Teams() {}

    public Teams(int teamId, int teamSize) {
        this.teamId = teamId;
        this.teamSize = teamSize;
    }


    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }


}
