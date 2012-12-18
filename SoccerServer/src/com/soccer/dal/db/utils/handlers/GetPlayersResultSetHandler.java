package com.soccer.dal.db.utils.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.db.utils.EntityFactory;
import com.soccer.entities.IDAOPlayer;

public class GetPlayersResultSetHandler implements ResultSetHandler<List<IDAOPlayer>> {
	public static final String QUERY = "SELECT * FROM %s.players";
	public static final String QUERY_ACTIVE = " WHERE Active = ?";
	
	private static final GetPlayersResultSetHandler instance = new GetPlayersResultSetHandler();
	
	public static GetPlayersResultSetHandler getInstance() {
		return instance;
	}
	
	public static String getQuery(String schema, boolean active) {
		if(active)
			return String.format(QUERY, schema).concat(QUERY_ACTIVE);
		return String.format(QUERY, schema);
	}
	
	@Override
	public List<IDAOPlayer> handle(ResultSet rslt) throws SQLException {
		List<IDAOPlayer> players = new ArrayList<IDAOPlayer>();
		while (rslt.next()) {
			players.add(EntityFactory.createPlayer(rslt));
		}
		return players;
	}

}
