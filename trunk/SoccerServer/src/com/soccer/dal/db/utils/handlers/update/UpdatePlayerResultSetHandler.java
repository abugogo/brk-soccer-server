package com.soccer.dal.db.utils.handlers.update;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.db.utils.EntityFactory;
import com.soccer.entities.IDAOPlayer;

public class UpdatePlayerResultSetHandler implements ResultSetHandler<IDAOPlayer> {

	public static final String QUERY = "UPDATE %s.players " + "SET position = ?, "
			+ "description = ?, Active = ? "
			+ "WHERE id = ?";
	private static final UpdatePlayerResultSetHandler instance = new UpdatePlayerResultSetHandler();
	
	public static UpdatePlayerResultSetHandler getInstance() {
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
