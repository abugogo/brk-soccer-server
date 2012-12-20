package com.soccer.dal.db.utils.handlers.sys;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

public class GetUserPasswordResultSetHandler implements ResultSetHandler<String> {

	private static final String QUERY = "SELECT pwd FROM abugogo_soccer_sys.users as u WHERE u.id = ?";
	private static final GetUserPasswordResultSetHandler instance = new GetUserPasswordResultSetHandler();

	public static GetUserPasswordResultSetHandler getInstance() {
		return instance;
	}

	public static String getQuery() {
		return QUERY;
	}
	
	@Override
	public String handle(ResultSet rslt) throws SQLException {
		String u = null;
		if (rslt.next()) {
			u = rslt.getString("pwd");
		}
		return u;
	}

}
