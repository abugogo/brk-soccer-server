package com.soccer.dal.db.utils.handlers.sys;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.db.utils.EntityFactory;
import com.soccer.entities.IDAOUser;

public class GetSingleUserResultSetHandler implements ResultSetHandler<IDAOUser> {

	public static final String QUERY = "SELECT * FROM SOCCER_SYS.Users WHERE id = ? AND pwd = ?";
	private static final GetSingleUserResultSetHandler instance = new GetSingleUserResultSetHandler();
	
	public static GetSingleUserResultSetHandler getInstance() {
		return instance;
	}
	
	@Override
	public IDAOUser handle(ResultSet rslt) throws SQLException {
		if (rslt.next()) {
			return EntityFactory.createUser(rslt);
		} else {
			return null;
		}
	}

}
