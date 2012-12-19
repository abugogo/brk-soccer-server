package com.soccer.dal.db.utils.handlers.create;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.db.utils.EntityFactory;
import com.soccer.entities.IDAOLineup;

public class CreateLineupResultSetHandler implements ResultSetHandler<IDAOLineup> {

	private static final String QUERY = "INSERT INTO %s.lineup"
			+ "(game_id, player_id, color, goal, " + "o_goal, points, misc) "
			+ "VALUES (?,?,?,?,?,?,?)";
	private static final CreateLineupResultSetHandler instance = new CreateLineupResultSetHandler();
	
	public static CreateLineupResultSetHandler getInstance() {
		return instance;
	}
	
	public static String getQuery(String schema) {
		return String.format(QUERY, schema);
	}
	
	@Override
	public IDAOLineup handle(ResultSet rslt) throws SQLException {
		if (rslt.next()) {
			return EntityFactory.createLineup(rslt);
		} else {
			return null;
		}
	}

}
