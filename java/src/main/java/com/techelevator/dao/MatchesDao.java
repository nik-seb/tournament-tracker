package com.techelevator.dao;

import com.techelevator.model.Matches;

import java.time.LocalDate;
import java.util.List;

public interface MatchesDao {


    Matches getMatch(int matchId);
    List<Matches> getMatchesByDate(LocalDate date);
    List<Matches> getMatchesByTournament(int tournamentId);
    Matches createMatch(Matches match);
    Matches updateMatch(int matchId);
    boolean deleteMatch(int matchId);
}
