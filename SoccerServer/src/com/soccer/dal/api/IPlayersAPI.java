package com.soccer.dal.api;

import java.util.List;

import com.soccer.entities.IDAOPlayer;
import com.soccer.entities.IWinLoseStrip;

public interface IPlayersAPI {
	List<IDAOPlayer> getActivePlayers();
	IDAOPlayer getPlayer(String pid);
	void createPlayer(IDAOPlayer p);
	void updatePlayer(IDAOPlayer p);
	List<IWinLoseStrip> getWinLoseStrips(String pid);
}
