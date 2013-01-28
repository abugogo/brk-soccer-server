package com.soccer.entities;

import com.soccer.entities.impl.DAOPosition;


/**
 * The persistent class for the players database table.
 * 
 */
public interface IDAOPlayer extends IDAOUser {
	public boolean isActive();
	public void setActive(boolean active);
	public String getDescription();
	public void setDescription(String description);
	public IDAOPosition getPositionBean();
	public void setPositionBean(DAOPosition positionBean);
	public boolean isAdmin();
	public boolean setAdmin(boolean val);
}