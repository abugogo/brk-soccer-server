package com.soccer.dal.db.utils.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.db.utils.EntityFactory;
import com.soccer.entities.IDAOGame;

public class GetSingleGameResultSetHandler implements ResultSetHandler<IDAOGame> {

	public static final String QUERY = "SELECT * FROM games_tbl WHERE game_id = ?";
	
	@Override
	public IDAOGame handle(ResultSet rslt) throws SQLException {
		if (rslt.next()) {
			return EntityFactory.createGame(rslt);
		} else {
			return null;
		}
	}

}
