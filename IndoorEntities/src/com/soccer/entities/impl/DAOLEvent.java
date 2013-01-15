package com.soccer.entities.impl;

import java.io.Serializable;
import java.sql.Time;

import com.soccer.entities.IDAOLEvent;

public class DAOLEvent implements Serializable, IDAOLEvent {
	private static final long serialVersionUID = 1L;
	private EventType type;
	private String gid = "";
	private String pid = "";
	private Time time = null;
	public static EventType[] enumAsArray = EventType.values();

	public EventType getType() {
		return type;
	}

	public void setType(EventType t) {
		type = t;

	}

	public void setType(int t) {
		if (t < enumAsArray.length)
			type = enumAsArray[t];
	}

	public String getGameId() {
		return gid;
	}

	public void setGameId(String gameId) {
		gid = gameId;

	}

	public String getPlayerId() {
		return pid;
	}

	public void setPlayerId(String id) {
		pid = id;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time t) {
		time = t;
	}

}
