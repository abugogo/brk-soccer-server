package com.soccer.dal.db.api;

import java.util.List;

import com.soccer.dal.entities.api.IDAOGame;

public interface IGamesAPI {
	public List<IDAOGame> getGames();
	public IDAOGame getGame(String gid);
}
