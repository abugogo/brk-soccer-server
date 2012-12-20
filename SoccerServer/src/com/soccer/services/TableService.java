package com.soccer.services;

import java.util.List;

import com.soccer.dal.api.ITableAPI;
import com.soccer.dal.db.SqlDBDal;
import com.soccer.entities.impl.TableRow;

public class TableService implements ITableAPI {
	private static TableService instance = null;
	
	public static TableService getInstance() {
		synchronized (TableService.class) {
			if (instance == null) {
				instance = new TableService();
			}
		}
		
		return instance;
	}
	
	private TableService() {
	}
	
	private ITableAPI tableAPI = SqlDBDal.getInst();

	@Override
	public List<TableRow> getPlayersTable() {
		return tableAPI.getPlayersTable();
	}

}
