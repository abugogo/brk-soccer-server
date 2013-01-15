package com.soccer.entities.impl;

import java.io.Serializable;
import java.util.HashMap;

import com.soccer.entities.IDAOPlayer;
import com.soccer.entities.IDAOPosition;


/**
 * The persistent class for the players database table.
 * 
 */
public class DAOPlayer extends DAOUser implements Serializable, IDAOPlayer  {
	private static final long serialVersionUID = 1L;
	private boolean active;
	private String description;
	private DAOPosition positionBean;
	private boolean isAdmin;

    public DAOPlayer() {
    	super();
    }

    public DAOPlayer(HashMap<String, Object> columns) {
    	super(columns);
    	setPlayer(columns);
    }

	private void setPlayer(HashMap<String, Object> columns) {
		this.setPositionBean(new DAOPosition());
		this.setDescription("" + columns.get("description"));
		this.setActive((Boolean)columns.get("Active"));
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

    public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IDAOPosition getPositionBean() {
		return this.positionBean;
	}

	public void setPositionBean(DAOPosition positionBean) {
		this.positionBean = positionBean;
	}

	public boolean isAdmin() {
		// TODO Auto-generated method stub
		return isAdmin;
	}

	public boolean setAdmin(boolean val) {
		// TODO Auto-generated method stub
		return isAdmin = val;
	}
}