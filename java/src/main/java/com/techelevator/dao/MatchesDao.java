package com.techelevator.dao;

import com.techelevator.model.Matches;

import java.util.List;

public interface MatchesDao {


    Matches getMatch(int matchId);
    List<Matches> getMatchesByDate(String date); // needs changed to localDate
    List<Matches> getMatchesByTournament(int tournamentId);
    Matches createMatch(Matches match);
    Matches updateMatch(int matchId);
    boolean deleteMatch(int matchId);
}
