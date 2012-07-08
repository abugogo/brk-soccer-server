package com.soccer.dal.db.api;

import java.util.List;

import com.soccer.dal.entities.api.IDAOPlayer;

public interface IPlayersAPI {
	public List<IDAOPlayer> getActivePlayers();
	public IDAOPlayer getPlayer(String pid);
}
