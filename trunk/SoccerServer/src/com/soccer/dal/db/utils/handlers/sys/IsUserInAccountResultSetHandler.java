package com.soccer.dal.db.utils.handlers.sys;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

public class IsUserInAccountResultSetHandler implements
		ResultSetHandler<Boolean> {
	public static final String QUERY = "SELECT * FROM ABUGOGO_SOCCER_SYS.usersacc WHERE uid = ? AND acc = ?";
	private static final IsUserInAccountResultSetHandler instance = new IsUserInAccountResultSetHandler();

	public static IsUserInAccountResultSetHandler getInstance() {
		return instance;
	}

	@Override
	public Boolean handle(ResultSet rslt) throws SQLException {
		return (rslt!= null && rslt.next());
	}
}
