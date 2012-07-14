package com.soccer.db.entities.handlers;

import java.util.List;

import com.soccer.dal.db.SqlDBDal;
import com.soccer.entities.IDAOPlayer;

public class PlayersActionHandler {
	static public List<IDAOPlayer> getAllPlayers() {
		List<IDAOPlayer> l = SqlDBDal.getInst().getActivePlayers();
		return l;
	}

	static public IDAOPlayer getPlayer(String pid) {
		IDAOPlayer p = SqlDBDal.getInst().getPlayer(pid);
		return p;
	}
	
	static public void createPlayer(IDAOPlayer p) {
		SqlDBDal.getInst().createPlayer(p);
	}
}
