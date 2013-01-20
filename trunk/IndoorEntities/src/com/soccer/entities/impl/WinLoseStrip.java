package com.soccer.entities.impl;

import java.util.Date;

import com.soccer.entities.IWinLoseStrip;

public class WinLoseStrip implements IWinLoseStrip {	
	private GameResultType type;
	private int number;
	private Date startDate;
	private Date endDate;
	
	public GameResultType getType() {
		return this.type;
	}

	public void setType(GameResultType type) {
		this.type = type;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
