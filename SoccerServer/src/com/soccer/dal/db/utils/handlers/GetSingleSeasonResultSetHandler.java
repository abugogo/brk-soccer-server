package com.soccer.dal.db.utils.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.db.utils.EntityFactory;
import com.soccer.entities.IDAOSeason;

public class GetSingleSeasonResultSetHandler implements ResultSetHandler<IDAOSeason> {
	public static String QUERY = 
			" SELECT id, sdate, edate, misc " +
			" FROM seasons " +
			" WHERE id = ? " +
			" ORDER BY sdate DESC ";
	private static GetSingleSeasonResultSetHandler instance = new GetSingleSeasonResultSetHandler();
	
	public static GetSingleSeasonResultSetHandler getInstance() {
		return instance;
	}

	@Override
	public IDAOSeason handle(ResultSet rslt) throws SQLException {
		return EntityFactory.createSeason(rslt);
	}

}