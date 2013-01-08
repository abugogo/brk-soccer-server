package com.soccer.dal.db.utils.handlers.sys;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

public class IsUserInAccountResultSetHandler implements
		ResultSetHandler<String> {
	// private static final String QUERY =
	// "SELECT * FROM abugogo_soccer_sys.usersacc WHERE uid = ? AND acc = ?";
	private static final String QUERY = "SELECT accschema FROM accmap INNER JOIN usersacc ON accname=acc WHERE uid=? AND accname=?";

	private static final IsUserInAccountResultSetHandler instance = new IsUserInAccountResultSetHandler();

	public static String getQuery() {
		return QUERY;
	}

	public static IsUserInAccountResultSetHandler getInstance() {
		return instance;
	}

	@Override
	public String handle(ResultSet rslt) throws SQLException {
		String acc = "";
		if (rslt != null && rslt.next())
			acc = rslt.getString("accschema");
		return acc;
	}
}
