package com.soccer.dal.db.utils.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.db.utils.EntityFactory;
import com.soccer.entities.IDAOPlayer;

public class GetSinglePlayerResultSetHandler implements ResultSetHandler<IDAOPlayer> {

	public static final String QUERY = "SELECT * FROM %s.players WHERE id = ?";
	private static final GetSinglePlayerResultSetHandler instance = new GetSinglePlayerResultSetHandler();
	
	public static GetSinglePlayerResultSetHandler getInstance() {
		return instance;
	}
	
	public static String getQuery(String schema) {
		return String.format(QUERY, schema);
	}
	
	@Override
	public IDAOPlayer handle(ResultSet rslt) throws SQLException {
		if (rslt.next()) {
			return EntityFactory.createPlayer(rslt);
		} else {
			return null;
		}
	}

}
