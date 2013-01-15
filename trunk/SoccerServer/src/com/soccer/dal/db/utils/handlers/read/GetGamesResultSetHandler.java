package com.soccer.dal.db.utils.handlers.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.db.utils.EntityFactory;
import com.soccer.entities.impl.DAOGame;
import com.soccer.entities.impl.DAOLEvent;
import com.soccer.entities.impl.PrintableLineup;

public class GetGamesResultSetHandler implements
		ResultSetHandler<HashMap<String, DAOGame>> {

	public static final String QUERY = " SELECT g.game_id, g.game_name, g.game_date, "
			+ "   g.winner, g.wgoals, g.bgoals, g.has_draft, "
			+ "   g.description, g.misc, g.more, l.player_id, "
			+ "   l.color, l.goal, l.o_goal, l.points, l.misc, "
			+ "   e.pid, e.gid, e.type, e.time, e.id"
			+ " FROM %s.games_tbl g "
			+ " LEFT OUTER JOIN %s.lineup l ON g.game_id = l.game_id "
			+ " LEFT OUTER JOIN %s.lineup_events e ON l.game_id = e.gid AND l.player_id = e.pid;";

	private static final GetGamesResultSetHandler instance = new GetGamesResultSetHandler();

	public static String getQuery(String schema) {
		return String.format(QUERY, schema, schema, schema);
	}

	public static GetGamesResultSetHandler getInstance() {
		return instance;
	}

	@Override
	public HashMap<String, DAOGame> handle(ResultSet rslt) throws SQLException {
		HashMap<String, DAOGame> games = new HashMap<String, DAOGame>();

		while (rslt.next()) {
			// first create a lineup. if the lineup's game was not created,
			// create it first.
			PrintableLineup d = EntityFactory.createLineup(rslt);
			DAOGame game = games.get(d.getGameId());
			if (game == null) {
				game = EntityFactory.createGame(rslt);
				games.put(game.getGameId(), game);
			}
			// add event to lineup
			DAOLEvent e = EntityFactory.createLEvent(rslt);
			if (e != null)
				d.addEvent(e);
			game.getLineup().add(d);
			
			

		}
		return games;
	}

}
