package com.soccer.dal.db.utils.handlers.create;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.entities.IDAOPlayer;

public class CreatePlayerResultSetHandler implements ResultSetHandler<IDAOPlayer> {

	public static final String QUERY = "INSERT INTO %s.players "
					+ "(id, position, description, Active) "
					+ "VALUES (?, ?, ?, ?)";
	private static final CreatePlayerResultSetHandler instance = new CreatePlayerResultSetHandler();
	
	public static CreatePlayerResultSetHandler getInstance() {
		return instance;
	}
	
	public static String getQuery(String schema) {
		return String.format(QUERY, schema);
	}
	
	@Override
	public IDAOPlayer handle(ResultSet rslt) throws SQLException {
		return null;
	}

}
