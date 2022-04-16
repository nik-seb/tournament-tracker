package com.techelevator.services;

import com.techelevator.model.Matches;
import com.techelevator.model.Teams;

import java.util.List;


public interface ServerTournamentService {

    List<Matches> generateBracket(List<Teams> teams, int tournamentId);
    List<Matches> generateMatches(List<Teams> teams);
    void advanceWinner();
    List<Teams> shuffle(List<Teams> teams);
    void endRound(List<Matches> matches);


}
