package com.soccer.dal.api;

import java.util.Date;
import java.util.List;

import com.soccer.entities.IDAOLEvent.EventType;
import com.soccer.entities.IDAOPlayer;
import com.soccer.entities.impl.DAOAggrLEvents;
import com.soccer.entities.impl.DAOMedal;
import com.soccer.entities.impl.DAOPlayer;

public interface IPlayersAPI {
	List<DAOPlayer> getActivePlayers();
	IDAOPlayer getPlayer(String pid);
	int createPlayer(IDAOPlayer p);
	int updatePlayer(IDAOPlayer p);
	List<DAOMedal> getPlayerStats(String pid);
	List<DAOAggrLEvents> getPlayerRecords(String pid, Date start, Date end);
	List<DAOAggrLEvents> getPlayersAggrEventTable(Date start, Date end, EventType type);
	List<DAOPlayer> getPlayers();
}
