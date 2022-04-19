package com.techelevator.dao;

import com.techelevator.model.Matches;

import java.time.LocalDate;
import java.util.List;

public interface MatchesDao {


    Matches getMatch(int matchId);
    List<Matches> getAllMatches();
    List<Matches> getMatchesByDate(LocalDate date);
    List<Matches> getMatchesByTournament(int tournamentId);
    List<Matches> getMatchByTournamentAndRound(int tournamentId, int roundNumber);
    Matches createMatch(Matches match, int tournamentId);
    Matches updateMatch(Matches match);
    Matches setMatchWinner(Matches match);
    boolean deleteMatch(int matchId);
}
