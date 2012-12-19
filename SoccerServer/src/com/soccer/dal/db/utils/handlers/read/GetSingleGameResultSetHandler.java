package com.soccer.dal.db.utils.handlers.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.db.utils.EntityFactory;
import com.soccer.entities.IDAOGame;
import com.soccer.entities.impl.DAOLineup;

public class GetSingleGameResultSetHandler implements ResultSetHandler<IDAOGame> {

	public static final String QUERY = 
			" SELECT g.game_id, g.game_name, g.game_date, " + 
			"   g.winner, g.wgoals, g.bgoals, g.has_draft, " + 
			"   g.description, g.misc, g.more, l.player_id, " + 
			"   l.color, l.goal, l.o_goal, l.points, l.misc " + 
			" FROM %s.games_tbl g " + 
			" LEFT OUTER JOIN %s.lineup l ON g.game_id = l.game_id " +
			" WHERE g.game_id = ?";
	private static final GetSingleGameResultSetHandler instance = new GetSingleGameResultSetHandler();
	
	public static GetSingleGameResultSetHandler getInstance() {
		return instance;
	}
	
	public static String getQuery(String schema) {
		return String.format(QUERY, schema, schema);
	}
	
	@Override
	public IDAOGame handle(ResultSet rslt) throws SQLException {
		if (rslt.next()) {
			IDAOGame game = EntityFactory.createGame(rslt);
			if (rslt.getString("l.player_id") != null) {
				game.setLineup(new ArrayList<DAOLineup>());
				game.getLineup().add(EntityFactory.createLineup(rslt));
				while(rslt.next()) {
					game.getLineup().add(EntityFactory.createLineup(rslt));
				}
			}
			return game;
		} else {
			return null;
		}
	}

}
