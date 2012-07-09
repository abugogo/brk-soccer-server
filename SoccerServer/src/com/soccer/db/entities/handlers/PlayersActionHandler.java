package com.soccer.db.entities.handlers;

import java.util.List;

import com.soccer.dal.entities.api.IDAOPlayer;
import com.soccer.db.impl.MYSQLDBDriver;

public class PlayersActionHandler {
	static public List<IDAOPlayer> getAllPlayers() {
		List<IDAOPlayer> l = MYSQLDBDriver.getInst().getActivePlayers();
		return l;
	}

	static public IDAOPlayer getPlayer(String pid) {
		IDAOPlayer p = MYSQLDBDriver.getInst().getPlayer(pid);
		return p;
	}
	
	static public void createPlayer(IDAOPlayer p) {
		MYSQLDBDriver.getInst().createPlayer(p);
	}
}
