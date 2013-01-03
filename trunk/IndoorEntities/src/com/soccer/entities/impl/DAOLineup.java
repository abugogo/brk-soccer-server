package com.soccer.entities.impl;

import java.io.Serializable;

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
	private int goal = 0;
	private String misc;
	private int oGoal = 0;
	private short points = 0;

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

	public int getGoal() {
		return this.goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public String getMisc() {
		return this.misc;
	}

	public void setMisc(String misc) {
		this.misc = misc;
	}

	public int getOGoal() {
		return this.oGoal;
	}

	public void setOGoal(int oGoal) {
		this.oGoal = oGoal;
	}

	public short getPoints() {
		return this.points;
	}

	public void setPoints(short points) {
		this.points = points;
	}

}