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

	public static int handle(QueryRunner qr, IDAOGame game) throws Exception {
		boolean commit = true;
		Connection conn = null;
		try {
			conn = qr.getDataSource().getConnection();
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
				int succUp[];
				PreparedStatement lustmt = conn
						.prepareStatement(CreateLineupResultSetHandler
								.getQuery(schema));
				for (Iterator<DAOLineup> it = game.getLineup().iterator(); it
						.hasNext();) {
					DAOLineup lineup = it.next();
					lustmt.setInt(1, game_id);
					lustmt.setInt(2, Integer.parseInt(lineup.getPlayerId()));
					lustmt.setString(3, lineup.getColor().toString());
					lustmt.setInt(4, lineup.getGoal());
					lustmt.setInt(5, lineup.getOGoal());
					lustmt.setInt(6, lineup.getPoints());
					lustmt.setString(7, "");
					lustmt.addBatch();
					// succUp += stmt.executeUpdate();
				}
				succUp = lustmt.executeBatch();
				commit = (succUp != null && succUp.length == game.getLineup()
						.size());
			} else
				commit = false;

			if (commit) {
				conn.commit();
				return game.getLineup().size() + 1;
			} else
				conn.rollback();

		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null)
				conn.rollback();
		}
		return 0;
	}
}
