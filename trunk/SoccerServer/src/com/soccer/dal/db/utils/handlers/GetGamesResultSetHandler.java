package com.soccer.dal.db.utils.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.db.utils.EntityFactory;
import com.soccer.entities.IDAOGame;

public class GetGamesResultSetHandler implements ResultSetHandler<List<IDAOGame>> {

	public static final String QUERY = "SELECT * FROM games_tbl";
	private static final GetGamesResultSetHandler instance = new GetGamesResultSetHandler();
	
	public static GetGamesResultSetHandler getInstance() {
		return instance;
	}
	
	@Override
	public List<IDAOGame> handle(ResultSet rslt) throws SQLException {
		List<IDAOGame> games = new ArrayList<IDAOGame>();
		while (rslt.next()) {
			games.add(EntityFactory.createGame(rslt));
		}
		return games;
	}

}
