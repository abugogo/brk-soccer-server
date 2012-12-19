package com.soccer.dal.api;

import java.util.List;

import com.soccer.entities.IDAOSeason;

public interface ISeasonAPI {
	IDAOSeason getSeason(int id);
	List<IDAOSeason> getSeasons();
	int createSeason(IDAOSeason season);
}
