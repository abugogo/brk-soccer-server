package com.soccer.services;

import java.util.List;

import com.soccer.dal.api.IGamesAPI;
import com.soccer.dal.api.IPlayersAPI;
import com.soccer.dal.db.SqlDBDal;
import com.soccer.entities.IDAOGame;
import com.soccer.entities.IDAOPlayer;
import com.soccer.entities.IWinLoseStrip;

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
	public List<IDAOPlayer> getPlayers() {
		return playersAPI.getPlayers();
	}
	
	@Override
	public List<IDAOPlayer> getActivePlayers() {
		return playersAPI.getActivePlayers();
	}

	@Override
	public IDAOPlayer getPlayer(String pid) {
		return playersAPI.getPlayer(pid);
	}

	@Override
	public List<IDAOGame> getGames() {
		return gameApi.getGames();
	}

	@Override
	public IDAOGame getGame(String gid) {
		return gameApi.getGame(gid);
	}

	@Override
	public void createPlayer(IDAOPlayer p) {
		playersAPI.createPlayer(p);
	}

	@Override
	public void createGame(IDAOGame game) {
		gameApi.createGame(game);
	}

	@Override
	public IDAOPlayer updatePlayer(IDAOPlayer p) {
		return playersAPI.updatePlayer(p);
	}

	@Override
	public List<IWinLoseStrip> getWinLoseStrips(String pid) {
		return playersAPI.getWinLoseStrips(pid);
	}
}