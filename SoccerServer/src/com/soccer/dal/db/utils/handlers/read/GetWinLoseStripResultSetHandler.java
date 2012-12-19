package com.soccer.dal.db.utils.handlers.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.entities.IWinLoseStrip;
import com.soccer.entities.impl.WinLoseStrip;

public class GetWinLoseStripResultSetHandler implements ResultSetHandler<List<IWinLoseStrip>> {
	
	public static final String QUERY = 
			"SELECT LNP.points, GMS.game_date " +
			"FROM %s.lineup LNP " +
			"  INNER JOIN %s.games_tbl GMS " +
			"  ON LNP.game_id=GMS.game_id " +
			"WHERE LNP.player_id = ? " +
			"ORDER BY LNP.game_id";
	private static final GetWinLoseStripResultSetHandler instance = new GetWinLoseStripResultSetHandler();
	
	public static GetWinLoseStripResultSetHandler getInstance() {
		return instance;
	}
	
	public static String getQuery(String schema) {
		return String.format(QUERY, schema, schema);
	}

	@Override
	public List<IWinLoseStrip> handle(ResultSet rslt) throws SQLException {
		List<IWinLoseStrip> res = new ArrayList<IWinLoseStrip>();
		Type lastType = null;
		IWinLoseStrip strip = null;
		int counter = 0;
		while (rslt.next()) {
			Type type = Type.fromPoints(rslt.getInt("points"), lastType);
			if (counter == 0) {
				strip = new WinLoseStrip();
				strip.setStartDate(rslt.getDate("game_date"));
				strip.setEndDate(rslt.getDate("game_date"));
				lastType = type;
				counter++;
			} else if (lastType == Type.TIE || type == Type.TIE || lastType == type) {
				if (type != Type.TIE) {
					lastType = type;
				}
				strip.setEndDate(rslt.getDate("game_date"));
				counter++;
			} else {
				// Add the strip
				strip.setNumber(counter);
				strip.setType(lastType.name());
				res.add(strip);
				
				// Start new strip
				strip = new WinLoseStrip();
				strip.setEndDate(rslt.getDate("game_date"));
				strip.setStartDate(rslt.getDate("game_date"));
				lastType = type;
				counter = 1;
			}
		}

		// Add the last strip
		if (lastType != null) {
			strip.setNumber(counter);
			strip.setType(lastType.name());
			res.add(strip);
		}
		
		return res;
	}
	
	private enum Type {
		WIN(3), LOSE(0), TIE(1);
		
		private int points;
		
		private Type(int points) {
			this.points = points;
		}
		
		public static Type fromPoints(int points, Type def) {
			for (Type t : Type.values()) {
				if (t.points == points) {
					return t;
				}
			}
			
			return def;
		}
}

}
