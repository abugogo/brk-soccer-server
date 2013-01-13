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
	protected String gameId;
	protected String playerId;
	protected Object color;
	protected String misc;
	protected short points = 0;
	protected List<DAOLEvent> lstEvents = new ArrayList<DAOLEvent>();

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
}