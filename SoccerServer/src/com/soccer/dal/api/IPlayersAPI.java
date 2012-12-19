package com.soccer.dal.api;

import java.util.List;

import com.soccer.entities.IDAOPlayer;
import com.soccer.entities.IWinLoseStrip;

public interface IPlayersAPI {
	List<IDAOPlayer> getActivePlayers();
	IDAOPlayer getPlayer(String pid);
	int createPlayer(IDAOPlayer p);
	int updatePlayer(IDAOPlayer p);
	List<IWinLoseStrip> getWinLoseStrips(String pid);
	List<IDAOPlayer> getPlayers();
}
