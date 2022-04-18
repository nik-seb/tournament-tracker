package com.techelevator.dao;

import com.techelevator.model.Invitation;

import java.util.List;

public interface InvitationDao {

    void createInvitation(Invitation invitation);

    List<Invitation> getInvitationByTournamentId(int tournamentId);

    List<Invitation> getInvitationByStatus(String status);

    List<Invitation> getInvitationByTeamId(int id);

    List<Invitation> getInvitationsByOrganizer (int id);

    Invitation updateInvitationStatus(Invitation invitation);



}
