package com.techelevator.model;

public class Tournament {
    private int tournamentId;
    private String tournamentName;
    private int numOfTeams;
    private String startDate;
    private String endDate;
    private int sportId;

    public Tournament(int tournamentId, String tournamentName, int numOfTeams, String startDate, String endDate, int sportId) {
        this.tournamentId = tournamentId;
        this.tournamentName = tournamentName;
        this.numOfTeams = numOfTeams;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sportId = sportId;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public int getNumOfTeams() {
        return numOfTeams;
    }

    public void setNumOfTeams(int numOfTeams) {
        this.numOfTeams = numOfTeams;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }
}
