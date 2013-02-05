package com.soccer.entities;

import java.sql.Time;

public interface IDAOLEvent {
	enum EventType {
		Goal,
		Cook,
		O_Goal,
		Y_Card,
		R_Card
	}
	public EventType getType();
	public void setType(EventType t);
	public String getGameId();
	public void setGameId(String gameId);
	public String getPlayerId();
	public void setPlayerId(String id);
	public String getPlayerFName();
	public void setPlayerFName(String name);
	public String getPlayerLName();
	public void setPlayerLName(String name);
	public Time getTime();
	public void setTime(Time t);
}
