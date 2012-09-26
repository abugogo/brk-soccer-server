package com.soccer.entities;

import java.util.Date;

public interface IWinLoseStrip {
	String getType();
	void setType(String type);
	int getNumber();
	void setNumber(int number);
	Date getStartDate();
	void setStartDate(Date startDate);
	Date getEndDate();
	void setEndDate(Date endDate);
}
