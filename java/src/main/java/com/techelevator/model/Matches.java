package com.techelevator.model;

public class Matches {


    private int matchId;
    private int tournamentId;
    private String date;
    private String startTime;
    private int homeTeamId;
    private int awayTeamId;

    public Matches() {}

    public Matches(int matchId, int tournamentId, String date, String startTime, int homeTeamId, int awayTeamId) {
        this.matchId = matchId;
        this.tournamentId = tournamentId;
        this.date = date;
        this.startTime = startTime;
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public int getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(int awayTeamId) {
        this.awayTeamId = awayTeamId;
    }




}



