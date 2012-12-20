package com.soccer.dal.db.utils.handlers.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.entities.impl.TableRow;

public class GetTableResultSetHandler implements ResultSetHandler<List<TableRow>> {
	public static final String QUERY = 
			" SELECT player_id, " +
			" 	fname, " +
			" 	lname, " +
			" 	count(*) games, " +
			" 	sum(goals) goals, " +
			" 	sum(own_goals) own_goals, " +
			" 	sum(points) points, " +
			" 	sum(wins) wins, " +
			" 	sum(losses) losses " + 
			" FROM ( " + 
			" 	SELECT p.id player_id, " +
			" 		p.fname fname, " +
			" 		p.lname lname, " +
			" 		l.goal goals, " +
			" 		l.points points, " +
			" 		l.o_goal own_goals,  " + 
			" 		CASE  " + 
			" 			WHEN l.points = 3 THEN 1 " + 
			" 			ELSE 0 " + 
			" 		END wins,  " + 
			" 		CASE  " + 
			" 			WHEN l.points = 0 THEN 1 " + 
			" 			ELSE 0 " + 
			" 	  	END losses " + 
			" 	FROM %s.players p " + 
			" 	INNER JOIN %s.lineup l " + 
			" 		ON l.player_id = p.id " + 
			" 	INNER JOIN %s.games_tbl g " + 
			" 		ON g.game_id = l.game_id " + 
			" 	WHERE p.active = 1 " + 
			" ) as data_tbl " + 
			" GROUP BY player_id, fname, lname " + 
			" ORDER BY points desc ";
	private static GetTableResultSetHandler instance = new GetTableResultSetHandler();
	
	public static GetTableResultSetHandler getInstance() {
		return instance;
	}
	
	public static String getQuery(String schema) {
		return String.format(QUERY, schema, schema, schema);
	}
	
	@Override
	public List<TableRow> handle(ResultSet rslt) throws SQLException {
		List<TableRow> table = new ArrayList<TableRow>();
		TableRow row;
		while (rslt.next()) {
			row = new TableRow();
			row.setFname(rslt.getString("fname"));
			row.setLname(rslt.getString("lname"));
			row.setPlayerId(rslt.getString("player_id"));
			row.setGames(rslt.getInt("games"));
			row.setGoals(rslt.getInt("goals"));
			row.setLosses(rslt.getInt("losses"));
			row.setOwnsGoals(rslt.getInt("own_goals"));
			row.setPoints(rslt.getInt("points"));
			row.setWins(rslt.getInt("wins"));
			table.add(row);
		}
		return table;
	}

}
