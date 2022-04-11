package com.techelevator.model;


public class Sports {


    private int sportId;
    private String sportName;


    public Sports() {}

    public Sports(int sportId, String sportName) {
        this.sportId = sportId;
        this.sportName = sportName;
    }


    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }


}
