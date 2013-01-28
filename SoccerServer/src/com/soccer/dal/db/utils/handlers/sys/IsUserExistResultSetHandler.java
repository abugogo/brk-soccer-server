package com.soccer.dal.db.utils.handlers.sys;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

public class IsUserExistResultSetHandler implements ResultSetHandler<Boolean> {
	private static final String QUERY = "SELECT 1 FROM abugogo_soccer_sys.users WHERE id = ? LIMIT 1";

	private static final IsUserExistResultSetHandler instance = new IsUserExistResultSetHandler();

	public static String getQuery() {
		return QUERY;
	}

	public static IsUserExistResultSetHandler getInstance() {
		return instance;
	}

	@Override
	public Boolean handle(ResultSet rslt) throws SQLException {
		Boolean response= false;
		if (rslt != null && rslt.next())
			response = true;
		return response;
	}
}
