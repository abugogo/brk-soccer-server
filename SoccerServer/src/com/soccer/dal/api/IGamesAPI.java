package com.soccer.dal.api;

import java.util.Map;

import com.soccer.entities.IDAOGame;
import com.soccer.entities.impl.DAOGame;

public interface IGamesAPI {
	Map<String, DAOGame> getGames();
	IDAOGame getGame(String gid);
	int createGame(IDAOGame game);
}
