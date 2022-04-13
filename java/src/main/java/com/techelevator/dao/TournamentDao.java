package com.techelevator.dao;

import com.techelevator.model.Tournament;

import java.util.List;

public interface TournamentDao {


    Tournament create(Tournament tournament);
    Tournament getTournamentById(int tournamentId);
    List<Tournament> getAllTournaments();
    Tournament updateTournament(int tournamentId);
    boolean deleteTournament(int tournamentId);
}
