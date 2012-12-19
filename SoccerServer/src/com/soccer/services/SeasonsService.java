package com.soccer.services;

import java.util.List;

import com.soccer.dal.api.ISeasonAPI;
import com.soccer.dal.db.SqlDBDal;
import com.soccer.entities.IDAOSeason;

public class SeasonsService implements ISeasonAPI {
	private static SeasonsService instance = null;
	
	private SeasonsService() {
		this.seasionAPI =  SqlDBDal.getInst();
	}
	
	public synchronized static SeasonsService getInstance() {
		if (instance == null) {
			instance = new SeasonsService();
		}
		
		return instance;
	}
	
	private ISeasonAPI seasionAPI;

	@Override
	public IDAOSeason getSeason(int id) {
		return this.seasionAPI.getSeason(id);
	}

	@Override
	public List<IDAOSeason> getSeasons() {
		return this.seasionAPI.getSeasons();
	}

	@Override
	public int createSeason(IDAOSeason season) {
		return this.seasionAPI.createSeason(season);
	}
}
