package com.soccer.entities.impl;

import java.io.Serializable;
import java.sql.Time;

import com.soccer.entities.IDAOLEvent;

public class DAOLEvent implements Serializable, IDAOLEvent {
	private static final long serialVersionUID = 1L;
	private EventType type;
	private String gid = "";
	private String pid = "";
	private String lname = "";
	private String fname = "";
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
	
	public static EventType getTypeFromInt(int t) {
		EventType ret = null;
		if(t >=0 && t < enumAsArray.length) {
			return enumAsArray[t];
		}
		return ret;
	}

	public String getPlayerFName() {
		return fname;
	}

	public void setPlayerFName(String name) {
		fname = name;
	}

	public String getPlayerLName() {
		return lname;
	}

	public void setPlayerLName(String name) {
		lname = name;
	}

}
