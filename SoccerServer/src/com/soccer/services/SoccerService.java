package com.soccer.services;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.soccer.dal.api.IGamesAPI;
import com.soccer.dal.api.IPlayersAPI;
import com.soccer.dal.db.SqlDBDal;
import com.soccer.entities.IDAOGame;
import com.soccer.entities.IDAOPlayer;
import com.soccer.entities.impl.DAOAggrLEvents;
import com.soccer.entities.impl.DAOGame;
import com.soccer.entities.impl.DAOMedal;
import com.soccer.entities.impl.DAOPlayer;

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
	public Map<String, DAOGame> getGames() {
		return gameApi.getGames();
	}

	@Override
	public IDAOGame getGame(String gid) {
		return gameApi.getGame(gid);
	}

	@Override
	public int createPlayer(IDAOPlayer p) {
		int res = 1;
		if(!SystemService.getInstance().isUserExists(p.getId()))
			res = SystemService.getInstance().createUser(p, p.getPassword());
		if(res > 0) {
			res = playersAPI.createPlayer(p);
			if(res > 0) {
				SystemService.getInstance().setUserInAccount(p.getId());
			}

		}
		return res;
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
	public List<DAOMedal> getPlayerStats(String pid) {
		return playersAPI.getPlayerStats(pid);
	}

	@Override
	public List<DAOAggrLEvents> getPlayerRecords(String pid, Date start, Date end) {
		return playersAPI.getPlayerRecords(pid, start, end);
	}

}
