package com.soccer.entities;

public interface ITableRow {
	String getPlayerId();
	void setPlayerId(String playerId);
	String getFname();
	void setFname(String fname);
	String getLname();
	void setLname(String lname);
	int getGames();
	void setGames(int games);
	int getGoals();
	void setGoals(int goals);
	int getOwnGoals();
	void setOwnsGoals(int ownGoals);
	int getPoints();
	void setPoints(int points);
	int getWins();
	void setWins(int wins);
	int getLosses();
	void setLosses(int losses);
}
