package com.soccer.dal.db.utils.handlers.create;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.db.utils.EntityFactory;
import com.soccer.entities.IDAOSeason;

public class CreateSeasonResultSetHandler implements
		ResultSetHandler<IDAOSeason> {

	private static final String QUERY = "IINSERT INTO %s.seasons "
			+ " (id, sdate, edate, misc) " + " VALUES (?, ?, ?, ?)";
	private static final CreateSeasonResultSetHandler instance = new CreateSeasonResultSetHandler();

	public static CreateSeasonResultSetHandler getInstance() {
		return instance;
	}

	public static String getQuery(String schema) {
		return String.format(QUERY, schema);
	}

	@Override
	public IDAOSeason handle(ResultSet rslt) throws SQLException {
		if (rslt.next()) {
			return EntityFactory.createSeason(rslt);
		} else {
			return null;
		}
	}

}
