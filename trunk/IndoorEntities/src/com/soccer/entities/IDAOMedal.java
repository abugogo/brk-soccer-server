package com.soccer.entities;

import java.util.Date;

public interface IDAOMedal {
	public enum MedalEnum{
		GOALS_PER_GAME,
		AGGR_GOALS,
		WIN_STREEK
	}
	
	public MedalEnum getMedalType();
	public void setMedalType(MedalEnum medal);
	public int getCount();
	public void setCount(int count);
	public Date getDate();
	public void setDate(Date date);
	public String getGameId();
	public void setGameID(String gid);	
}
