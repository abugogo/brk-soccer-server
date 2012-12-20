package com.soccer.dal.api;

import java.util.List;

import com.soccer.entities.IDAOPlayer;
import com.soccer.entities.impl.DAOPlayer;
import com.soccer.entities.impl.WinLoseStrip;

public interface IPlayersAPI {
	List<DAOPlayer> getActivePlayers();
	IDAOPlayer getPlayer(String pid);
	int createPlayer(IDAOPlayer p);
	int updatePlayer(IDAOPlayer p);
	List<WinLoseStrip> getWinLoseStrips(String pid);
	List<DAOPlayer> getPlayers();
}
