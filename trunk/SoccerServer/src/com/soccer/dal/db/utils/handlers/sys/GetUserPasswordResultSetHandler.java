package com.soccer.dal.db.utils.handlers.sys;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

public class GetUserPasswordResultSetHandler implements ResultSetHandler<String> {

	public static final String QUERY = "SELECT pwd FROM ABUGOGO_SOCCER_SYS.Users as u WHERE u.id = ?";
	private static final GetUserPasswordResultSetHandler instance = new GetUserPasswordResultSetHandler();

	public static GetUserPasswordResultSetHandler getInstance() {
		return instance;
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
