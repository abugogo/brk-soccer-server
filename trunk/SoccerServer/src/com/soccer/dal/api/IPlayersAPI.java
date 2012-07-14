package com.soccer.dal.api;

import java.util.List;

import com.soccer.entities.IDAOPlayer;

public interface IPlayersAPI {
	List<IDAOPlayer> getActivePlayers();
	IDAOPlayer getPlayer(String pid);
	void createPlayer(IDAOPlayer p);
}