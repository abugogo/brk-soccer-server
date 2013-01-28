package com.soccer.dal.db.utils.handlers.sys;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

public class SetUserInAccountResultSetHandler implements ResultSetHandler<Void> {

	public static final String QUERY = "INSERT INTO abugogo_soccer_sys.usersacc "
			+ "(uid, acc) "
			+ "VALUES (?, ?)";
	private static final SetUserInAccountResultSetHandler instance = new SetUserInAccountResultSetHandler();
	
	public static SetUserInAccountResultSetHandler getInstance() {
		return instance;
	}
	
	public static String getQuery() {
		return QUERY;
	}

	@Override
	public Void handle(ResultSet arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
