package com.soccer.entities.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.soccer.entities.IDAOLEvent;
import com.soccer.entities.IDAOLineup;

/**
 * The persistent class for the lineup database table.
 * 
 */
public class DAOLineup implements Serializable, IDAOLineup {
	private static final long serialVersionUID = 1L;
	private String gameId;
	private String playerId;
	private Object color;
	private String misc;
	private short points = 0;
	private List<DAOLEvent> lstEvents = new ArrayList<DAOLEvent>();

	public DAOLineup() {
	}

	public String getGameId() {
		return this.gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public Object getColor() {
		return this.color;
	}

	public void setColor(Object color) {
		this.color = color;
	}

	public int getAggregatedEvent(IDAOLEvent.EventType et) {
		int g = 0;
		for (DAOLEvent ge : lstEvents) {
			if (ge.getType() == et)
				g++;
		}
		return g;
	}

	public int getGoal() {
		return getAggregatedEvent(IDAOLEvent.EventType.Goal);
	}

	public String getMisc() {
		return this.misc;
	}

	public void setMisc(String misc) {
		this.misc = misc;
	}

	public int getOGoal() {
		return getAggregatedEvent(IDAOLEvent.EventType.O_Goal);
	}

	public short getPoints() {
		return this.points;
	}

	public void setPoints(short points) {
		this.points = points;
	}

	public List<DAOLEvent> getEvents() {
		return lstEvents;
	}

	public void clearEvents() {
		if (lstEvents != null)
			lstEvents.clear();
	}

	public void addEvent(DAOLEvent ev) {
		lstEvents.add(ev);
	}

	public String toStringEvents() {
		String evts = "";
		int g = 0, og = 0, r = 0, y = 0, c = 0;
		for (DAOLEvent ge : lstEvents) {
			switch (ge.getType()) {
			case Goal:
				g++;
				break;
			case O_Goal:
				og++;
				break;
			case Y_Card:
				y++;
				break;
			case R_Card:
				r++;
				break;
			case Cook:
				c++;
				break;
			}
		}
		evts = playerId
				+ (((g + og + r + y + c) > 0) ? "(" + g + "," + og + "," + r
						+ "," + y + "," + c + ")" : "");
		return evts;
	}

}