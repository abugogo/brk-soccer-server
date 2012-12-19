package com.soccer.dal.db.utils.handlers.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.db.utils.EntityFactory;
import com.soccer.entities.IDAOGame;
import com.soccer.entities.impl.DAOLineup;

public class GetGamesResultSetHandler implements ResultSetHandler<List<IDAOGame>> {

	public static final String QUERY = 
			" SELECT g.game_id, g.game_name, g.game_date, " + 
			"   g.winner, g.wgoals, g.bgoals, g.has_draft, " + 
			"   g.description, g.misc, g.more, l.player_id, " + 
			"   l.color, l.goal, l.o_goal, l.points, l.misc " + 
			" FROM %s.games_tbl g " + 
			" LEFT OUTER JOIN %s.lineup l ON g.game_id = l.game_id ";
	private static final GetGamesResultSetHandler instance = new GetGamesResultSetHandler();
	
	public static String getQuery(String schema) {
		return String.format(QUERY, schema, schema);
	}
	
	public static GetGamesResultSetHandler getInstance() {
		return instance;
	}
	
	
	
	@Override
	public List<IDAOGame> handle(ResultSet rslt) throws SQLException {
		List<IDAOGame> games = new ArrayList<IDAOGame>();
		IDAOGame lastGame = null;
		while (rslt.next()) {
			if (lastGame == null || !rslt.getString("g.game_id").equals(lastGame.getGameId())) {
				lastGame = EntityFactory.createGame(rslt);
				games.add(lastGame);
			}
			
			if (rslt.getString("l.player_id") != null) {
				if (lastGame.getLineup() == null) {
					lastGame.setLineup(new ArrayList<DAOLineup>());
				}
				lastGame.getLineup().add(EntityFactory.createLineup(rslt));
			}
		}
		return games;
	}

}
