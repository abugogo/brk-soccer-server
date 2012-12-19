package com.soccer.dal.db.utils.handlers.create;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import org.apache.commons.dbutils.QueryRunner;

import com.soccer.entities.IDAOGame;
import com.soccer.entities.impl.DAOLineup;
import com.soccer.http.context.RequestContext;

public class CreateGameHandler {
	private static final String QUERY = "INSERT INTO %s.games_tbl "
			+ "(game_name, game_date, winner, "
			+ "wgoals, bgoals, has_draft, description, " + "misc, more) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static String getQuery(String schema) {
		return String.format(QUERY, schema, schema);
	}

	public static int handle(QueryRunner qr, IDAOGame game) {
		try {
			Connection conn = qr.getDataSource().getConnection();
			conn.setAutoCommit(false);
			String schema = (String) RequestContext
					.getAttribute(RequestContext.REQ_CONTEXT);

			PreparedStatement stmt = conn.prepareStatement(getQuery(schema),
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, "");
			stmt.setDate(2, new java.sql.Date(game.getGameDate().getTime()));
			stmt.setString(3, game.getWinner().toString());
			stmt.setInt(4, game.getWgoals());
			stmt.setInt(5, game.getBgoals());
			stmt.setInt(6, 0);
			stmt.setString(7, "");
			stmt.setString(8, "");
			stmt.setString(9, "");

			stmt.executeUpdate();
			ResultSet res = stmt.getGeneratedKeys();
			int game_id = 0;
			if (res.next())
				game_id = res.getInt(1);
			if (game_id != 0) {
				for (Iterator<DAOLineup> it = game.getLineup().iterator(); it
						.hasNext();) {
					DAOLineup lineup = it.next();
					qr.update(conn,
							CreateLineupResultSetHandler.getQuery(schema),
							CreateLineupResultSetHandler.getInstance(),
							game_id, lineup.getPlayerId(), lineup.getColor(),
							lineup.getGoal(), lineup.getOGoal(),
							lineup.getPoints(), lineup.getMisc());
				}
				conn.commit();
			} else
				conn.rollback();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
