package com.techelevator.dao;

import com.techelevator.model.Tournament;

import java.util.List;

public interface TournamentDao {
    public Tournament create(Tournament tournament);
    public Tournament getTournamentById(int tournamentId);
    public List<Tournament> getAllTournaments();
    public Tournament updateTournament(Tournament tournament, int tournamentId);
}
