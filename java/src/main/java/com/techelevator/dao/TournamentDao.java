package com.techelevator.dao;

import com.techelevator.exception.TournamentNotFoundException;
import com.techelevator.model.Tournament;

import java.util.List;

public interface TournamentDao {


    Tournament create(Tournament tournament) throws TournamentNotFoundException;
    Tournament getTournamentById(int tournamentId) throws TournamentNotFoundException;
    List<Tournament> getAllTournaments();
    Tournament updateTournament(int tournamentId) throws TournamentNotFoundException;
    boolean deleteTournament(int tournamentId) throws TournamentNotFoundException;
}
