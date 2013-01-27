package com.soccer.entities.impl;

import com.soccer.entities.IDAOAggrLEvents;

public class DAOAggrLEvents extends DAOLEvent implements IDAOAggrLEvents {

	private static final long serialVersionUID = 1L;
	private int _count = 0;
	
	public int getCount() {
		return _count;
	}
	
	public void setCount(int c) {
		_count = c;
	}

}
