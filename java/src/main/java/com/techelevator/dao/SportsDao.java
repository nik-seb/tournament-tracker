package com.techelevator.dao;

import com.techelevator.model.Sports;

import java.util.List;

public interface SportsDao {
    Sports getSport(int sportId);

    List<Sports> getAllSports(String sportName);

    Sports createSport(Sports sport);

    void updateSport(Sports sport);

    void deleteSport(int sportId);

}
