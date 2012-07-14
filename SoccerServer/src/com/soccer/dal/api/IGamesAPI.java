package com.soccer.dal.api;

import java.util.List;

import com.soccer.entities.IDAOGame;

public interface IGamesAPI {
	List<IDAOGame> getGames();
	IDAOGame getGame(String gid);
}
