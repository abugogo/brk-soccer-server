package com.soccer.dal.db.utils.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.db.utils.EntityFactory;
import com.soccer.entities.IDAOPlayer;

public class GetPlayersResultSetHandler implements ResultSetHandler<List<IDAOPlayer>> {

	public static final String QUERY = "SELECT * FROM players WHERE Active = ?";
	
	@Override
	public List<IDAOPlayer> handle(ResultSet rslt) throws SQLException {
		List<IDAOPlayer> players = new ArrayList<>();
		while (rslt.next()) {
			players.add(EntityFactory.createPlayer(rslt));
		}
		return players;
	}

}
