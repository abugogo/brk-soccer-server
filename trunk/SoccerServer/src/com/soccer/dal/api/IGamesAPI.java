package com.soccer.dal.api;

import java.util.List;

import com.soccer.entities.IDAOGame;
import com.soccer.entities.impl.DAOGame;

public interface IGamesAPI {
	List<DAOGame> getGames();
	IDAOGame getGame(String gid);
	int createGame(IDAOGame game);
}
