package com.soccer.db.entities.handlers;

import java.util.List;

import com.soccer.dal.db.MYSQLDBDriver;
import com.soccer.entities.IDAOGame;

public class GamesActionHandler {

	static public List<IDAOGame> getAllGames() {
		List<IDAOGame> l = MYSQLDBDriver.getInst().getGames();
		return l;
	}

	static public IDAOGame getGame(String gid) {
		IDAOGame g = MYSQLDBDriver.getInst().getGame(gid);
		return g;
	}
}
