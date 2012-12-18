package com.soccer.dal.db.utils.handlers.sys;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

public class GetUserSaltResultSetHandler implements ResultSetHandler<String> {

	public static final String QUERY = "SELECT salt FROM abugogo_soccer_sys.users as u WHERE u.id = ?";
	private static final GetUserSaltResultSetHandler instance = new GetUserSaltResultSetHandler();

	public static GetUserSaltResultSetHandler getInstance() {
		return instance;
	}

	@Override
	public String handle(ResultSet rslt) throws SQLException {
		String u = null;
		if (rslt.next()) {
			u = rslt.getString("salt");
		}
		return u;
	}

}
