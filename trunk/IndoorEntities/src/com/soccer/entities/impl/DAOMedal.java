package com.soccer.entities.impl;

import java.util.Date;

import com.soccer.entities.IDAOMedal;

public class DAOMedal implements IDAOMedal {
	private MedalEnum _medalType;
	private String _gameid;
	private int _count;
	private Date _date;

	public MedalEnum getMedalType() {
		return _medalType;
	}

	public void setMedalType(MedalEnum medal) {
		_medalType = medal;

	}

	public int getCount() {
		return _count;
	}

	public void setCount(int count) {
		_count = count;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	public String getGameId() {
		return _gameid;
	}

	public void setGameID(String gid) {
		_gameid = gid;
	}

}
