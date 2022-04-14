package com.techelevator.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.time.LocalDate;


public class Tournament {


    @Min(value = 1, message = "Tournament ID Should Be a Positive Number.")
    private int tournamentId;

    @NotBlank( message = "Tournament Name is Required.")
    private String tournamentName;

    @Min(value = 1, message = "Number Of Teams Should Be a Positive Number.")
    private int numOfTeams;


    private LocalDate startDate;
    private LocalDate endDate;

    @Min(value = 1, message = "Sport ID Should Be a Positive Number.")
    private int sportId;

    public Tournament() {};

    public Tournament(int tournamentId, String tournamentName, int numOfTeams, LocalDate startDate, LocalDate endDate, int sportId) {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getSportId() {
        return sportId;
    }

    public void setSportId(int sportId) {
        this.sportId = sportId;
    }
}
