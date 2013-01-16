package com.soccer.services;

import java.util.Collection;
import java.util.List;

import com.soccer.dal.api.IGamesAPI;
import com.soccer.dal.api.IPlayersAPI;
import com.soccer.dal.db.SqlDBDal;
import com.soccer.entities.IDAOGame;
import com.soccer.entities.IDAOPlayer;
import com.soccer.entities.impl.DAOGame;
import com.soccer.entities.impl.DAOPlayer;
import com.soccer.entities.impl.WinLoseStrip;

public class SoccerService implements IGamesAPI, IPlayersAPI {
	private static SoccerService instance = null;
	
	public static SoccerService getInstance() {
		synchronized (SoccerService.class) {
			if (instance == null) {
				instance = new SoccerService();
			}
		}
		
		return instance;
	}
	
	private SoccerService() {
	}
	
	IGamesAPI gameApi = SqlDBDal.getInst();
	IPlayersAPI playersAPI = SqlDBDal.getInst();
	
	@Override
	public List<DAOPlayer> getPlayers() {
		return playersAPI.getPlayers();
	}
	
	@Override
	public List<DAOPlayer> getActivePlayers() {
		return playersAPI.getActivePlayers();
	}

	@Override
	public IDAOPlayer getPlayer(String pid) {
		return playersAPI.getPlayer(pid);
	}

	@Override
	public Collection<DAOGame> getGames() {
		return gameApi.getGames();
	}

	@Override
	public IDAOGame getGame(String gid) {
		return gameApi.getGame(gid);
	}

	@Override
	public int createPlayer(IDAOPlayer p) {
		return playersAPI.createPlayer(p);
	}

	@Override
	public int createGame(IDAOGame game) {
		return gameApi.createGame(game);
	}

	@Override
	public int updatePlayer(IDAOPlayer p) {
		return playersAPI.updatePlayer(p);
	}

	@Override
	public List<WinLoseStrip> getWinLoseStrips(String pid) {
		return playersAPI.getWinLoseStrips(pid);
	}
}
