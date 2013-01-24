package com.soccer.entities;

import java.util.Date;

public interface IDAOMedal {
	public enum MedalEnum{
		HATTRICK,
		TWENTY_FIVE_GOALS,
		TEN_GAME_WIN_STREEK
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
