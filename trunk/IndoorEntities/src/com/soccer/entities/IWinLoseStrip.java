package com.soccer.entities;

import java.util.Date;

public interface IWinLoseStrip {
	public enum GameResultType {
		WIN, LOSE, TIE;
	}
	
	GameResultType getType();
	void setType(GameResultType type);
	int getNumber();
	void setNumber(int number);
	Date getStartDate();
	void setStartDate(Date startDate);
	Date getEndDate();
	void setEndDate(Date endDate);
}
