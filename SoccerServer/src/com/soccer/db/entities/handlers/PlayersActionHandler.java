package com.soccer.db.entities.handlers;

import java.util.List;

import com.soccer.dal.db.MYSQLDBDriver;
import com.soccer.entities.IDAOPlayer;

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
