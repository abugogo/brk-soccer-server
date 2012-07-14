package com.soccer.db.entities.handlers;

import java.util.List;

import com.soccer.dal.db.SqlDBDal;
import com.soccer.entities.IDAOGame;

public class GamesActionHandler {

	static public List<IDAOGame> getAllGames() {
		List<IDAOGame> l = SqlDBDal.getInst().getGames();
		return l;
	}

	static public IDAOGame getGame(String gid) {
		IDAOGame g = SqlDBDal.getInst().getGame(gid);
		return g;
	}
}
