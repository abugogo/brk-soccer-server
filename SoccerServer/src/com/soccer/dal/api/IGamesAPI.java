package com.soccer.dal.api;

import java.util.HashMap;

import com.soccer.entities.IDAOGame;
import com.soccer.entities.impl.DAOGame;

public interface IGamesAPI {
	HashMap<String, DAOGame> getGames();
	IDAOGame getGame(String gid);
	int createGame(IDAOGame game);
}
