package com.techelevator.model;

import javax.validation.constraints.Min;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Teams {

    @Min(value = 1, message = "Team ID Should Be a Positive Number.")
    private int teamId;

    @Min(value = 1, message = "Team Size Should Be a Positive Number.")
    private int teamSize;
    private String teamName;

    public Teams() {}

<<<<<<< HEAD
    public Teams(int teamId, String teamName, int teamSize) {
=======
    public Teams(int teamId, int teamSize, String teamName) {
>>>>>>> 01cfa1a25e4d93a88b4a07ff67d89d67c614c68f
        this.teamId = teamId;
        this.teamSize = teamSize;
        this.teamName = teamName;
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
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


}
