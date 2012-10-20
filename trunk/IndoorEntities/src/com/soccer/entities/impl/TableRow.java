package com.soccer.entities.impl;

import com.soccer.entities.ITableRow;

public class TableRow implements ITableRow {
	private String playerId;
	private String fname;
	private String lname;
	private int games;
	private int wins;
	private int losses;
	private int points;
	private int goals;
	private int ownGoals;

	public String getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getGames() {
		return this.games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public int getGoals() {
		return this.goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getOwnGoals() {
		return this.ownGoals;
	}

	public void setOwnsGoals(int ownGoals) {
		this.ownGoals = ownGoals;
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getWins() {
		return this.wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return this.losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}
}
