package com.techelevator.dao;

import com.techelevator.model.Matches;

import java.util.List;

public interface MatchesDao {
    Matches getMatch(int matchId);

    List<Matches> getMatchesByDate(String date);

    List<Matches> getMatchesByTournament(String tournamentId);

    Matches createMatch(Matches match);

    void updateMatch(Matches match);

    void deleteMatch(int matchId);
}
