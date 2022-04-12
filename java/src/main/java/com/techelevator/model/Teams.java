package com.techelevator.model;

import javax.validation.constraints.Min;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Teams {

    @Min(value = 1, message = "Team ID Should Be a Positive Number.")
    private int teamId;

    @Min(value = 1, message = "Team Size Should Be a Positive Number.")
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
