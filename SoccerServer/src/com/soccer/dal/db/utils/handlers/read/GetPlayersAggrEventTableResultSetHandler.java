package com.soccer.dal.db.utils.handlers.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.entities.impl.DAOAggrLEvents;

public class GetPlayersAggrEventTableResultSetHandler implements
		ResultSetHandler<List<DAOAggrLEvents>> {

	public static final String QUERY = "{CALL %s.getPlayerAggrEventTable(?,?,?)}";
	private static final GetPlayersAggrEventTableResultSetHandler instance = new GetPlayersAggrEventTableResultSetHandler();

	public static GetPlayersAggrEventTableResultSetHandler getInstance() {
		return instance;
	}

	public static String getQuery(String schema) {
		return String.format(QUERY, schema);
	}

	@Override
	public List<DAOAggrLEvents> handle(ResultSet rslt) throws SQLException {
		List<DAOAggrLEvents> res = new ArrayList<DAOAggrLEvents>();

		DAOAggrLEvents evt = null;

		while (rslt.next()) {
			evt = new DAOAggrLEvents();
			int count = rslt.getInt("count");
			int type = rslt.getInt("type");
			String id = rslt.getString("pid"); 
			String fname = rslt.getString("fname");
			String lname = rslt.getString("lname");
			evt.setCount(count);
			evt.setPlayerId(id);
			evt.setType(type);
			evt.setPlayerFName(fname);
			evt.setPlayerLName(lname);
			
			res.add(evt);
		}

		return res;
	}
}
