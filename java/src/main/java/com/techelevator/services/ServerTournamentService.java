package com.techelevator.services;

import com.techelevator.model.Matches;
import com.techelevator.model.Teams;

import java.util.List;


public interface ServerTournamentService {

    List<Matches> generateBracket(List<Teams> teams, int tournamentId);
    List<Matches> generateMatchesByRound(List<Teams> teams);

    List<Matches> updateBracket(List<Teams> teams, int tournamentId, int roundNum);

    void advanceWinner();
    void endRound(List<Matches> matches);


}
