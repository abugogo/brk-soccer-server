package com.soccer.db.utils.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.entities.api.IDAOPlayer;
import com.soccer.db.utils.EntityFactory;

public class GetSinglePlayerResultSetHandler implements ResultSetHandler<IDAOPlayer> {

	public static final String QUERY = "SELECT * FROM players WHERE id = ?";
	
	@Override
	public IDAOPlayer handle(ResultSet rslt) throws SQLException {
		if (rslt.next()) {
			return EntityFactory.createPlayer(rslt);
		} else {
			return null;
		}
	}

}
