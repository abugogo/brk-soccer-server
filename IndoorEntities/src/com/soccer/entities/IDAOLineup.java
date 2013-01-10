package com.soccer.entities;

import java.util.List;

import com.soccer.entities.impl.DAOLEvent;

/**
 * The persistent class for the lineup database table.
 * 
 */
public interface IDAOLineup {
	public String getGameId();
	public void setGameId(String gameId);
	public String getPlayerId();
	public void setPlayerId(String playerId);

	public Object getColor();
	public void setColor(Object color);
	public int getGoal();
	public String getMisc();
	public void setMisc(String misc);
	public int getOGoal();
	public short getPoints();
	public void setPoints(short points);
	public List<DAOLEvent> getEvents();
	public void clearEvents();
	public void addEvent(DAOLEvent ev);
}