package com.soccer.entities;

import java.util.Date;
import java.util.List;

import com.soccer.entities.impl.PrintableLineup;

public interface IDAOGame {
	public String getGameId();

	public void setGameId(String gameId);

	public int getBgoals();

	public void setBgoals(int bgoals);

	public String getDescription();

	public void setDescription(String description);

	public Date getGameDate();

	public void setGameDate(Date gameDate);

	public String getGameName();

	public void setGameName(String gameName);

	public byte getHasDraft();

	public void setHasDraft(byte hasDraft);

	public String getMisc();

	public void setMisc(String misc);

	public String getMore();

	public void setMore(String more);

	public int getWgoals();

	public void setWgoals(int wgoals);

	public Object getWinner();

	public void setWinner(Object winner);

	public List<PrintableLineup> getLineup();

	public void setLineup(List<PrintableLineup> lineup);
}