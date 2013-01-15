package com.soccer.dal.db.utils.handlers.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.db.utils.EntityFactory;
import com.soccer.entities.IDAOGame;
import com.soccer.entities.impl.DAOLEvent;
import com.soccer.entities.impl.PrintableLineup;

public class GetSingleGameResultSetHandler implements
		ResultSetHandler<IDAOGame> {

	public static final String QUERY = " SELECT g.game_id, g.game_name, g.game_date, "
			+ "   g.winner, g.wgoals, g.bgoals, g.has_draft, "
			+ "   g.description, g.misc, g.more, l.player_id, "
			+ "   l.color, l.goal, l.o_goal, l.points, l.misc, "
			+ "   e.pid, e.gid, e.type, e.time, e.id"
			+ " FROM %s.games_tbl g "
			+ " LEFT OUTER JOIN %s.lineup l ON g.game_id = l.game_id "
			+ " LEFT OUTER JOIN %s.lineup_events e ON l.game_id = e.gid AND l.player_id = e.pid "
			+ " WHERE g.game_id = ?";
	private static final GetSingleGameResultSetHandler instance = new GetSingleGameResultSetHandler();

	public static GetSingleGameResultSetHandler getInstance() {
		return instance;
	}

	public static String getQuery(String schema) {
		return String.format(QUERY, schema, schema, schema);
	}

	@Override
	public IDAOGame handle(ResultSet rslt) throws SQLException {
		boolean first = true;
		IDAOGame game = null;
		while (rslt.next()) {
			if (first) {
				game = EntityFactory.createGame(rslt);
				game.setLineup(new ArrayList<PrintableLineup>());
				first = false;
			}
			PrintableLineup d = EntityFactory.createLineup(rslt);
			DAOLEvent e = EntityFactory.createLEvent(rslt);
			if (e != null)
				d.addEvent(e);
			game.getLineup().add(d);
			
		}
		return game;
	}

}
