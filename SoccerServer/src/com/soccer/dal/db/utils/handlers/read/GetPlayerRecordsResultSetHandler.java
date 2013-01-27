package com.soccer.dal.db.utils.handlers.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.entities.IDAOLEvent.EventType;
import com.soccer.entities.impl.DAOAggrLEvents;

public class GetPlayerRecordsResultSetHandler implements
		ResultSetHandler<List<DAOAggrLEvents>> {

	public static final String QUERY = "{CALL %s.getPlayersRecords(?,?,?)}";
	private static final GetPlayerRecordsResultSetHandler instance = new GetPlayerRecordsResultSetHandler();

	public static GetPlayerRecordsResultSetHandler getInstance() {
		return instance;
	}

	public static String getQuery(String schema) {
		return String.format(QUERY, schema);
	}

	@Override
	public List<DAOAggrLEvents> handle(ResultSet rslt) throws SQLException {
		List<DAOAggrLEvents> res = new LinkedList<DAOAggrLEvents>();

		int maxc = 0, maxg = 0;
		DAOAggrLEvents max_cooks_evt  = new DAOAggrLEvents(), max_goals_evt  = new DAOAggrLEvents();
		
		while (rslt.next()) {
			int tc = rslt.getInt("tc");
			if (maxc ==0 || tc > maxc) {
				max_cooks_evt = initEvent(rslt.getString("g"), rslt.getString("pid"), EventType.Cook, tc);
				maxc = tc;
			}
			int tg = rslt.getInt("tg");
			if (maxg == 0 || tg > maxg) {
				max_goals_evt = initEvent(rslt.getString("g"), rslt.getString("pid"), EventType.Goal, tg);
				maxg = tg;
			}
		}
		res.add(max_goals_evt);
		res.add(max_cooks_evt);
		return res;
	}
	
	private DAOAggrLEvents initEvent(String game_id, String player_id, EventType type, int count) {
		DAOAggrLEvents evt = new DAOAggrLEvents();
		evt.setGameId(game_id);
		evt.setPlayerId(player_id);
		evt.setType(type);
		evt.setCount(count);
		return evt;
	}
}
