package com.soccer.dal.api;

import java.util.Collection;

import com.soccer.entities.IDAOGame;
import com.soccer.entities.impl.DAOGame;

public interface IGamesAPI {
	Collection<DAOGame> getGames();
	IDAOGame getGame(String gid);
	int createGame(IDAOGame game);
}
