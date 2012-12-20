package com.soccer.dal.db.utils.handlers.sys;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.db.utils.EntityFactory;
import com.soccer.entities.IDAOPlayer;

public class UpdateUserResultSetHandler implements ResultSetHandler<IDAOPlayer> {

	private static final String QUERY = "UPDATE abugogo_soccer_sys.users"
			+ " SET fname = ?, lname = ?, tel1 = ?, tel2 = ?, email = ?, bday = ?,"
			+ " fb_user = ?, occupation = ?, address1 = ?, address2 = ?, P_img  = ?"
			+ " WHERE id = ?";
	private static final UpdateUserResultSetHandler instance = new UpdateUserResultSetHandler();

	public static UpdateUserResultSetHandler getInstance() {
		return instance;
	}

	public static String getQuery() {
		return QUERY;
	}

	@Override
	public IDAOPlayer handle(ResultSet rslt) throws SQLException {
		if (rslt.next()) {
			return EntityFactory.createPlayer(rslt);
		} else {
			return null;
		}
	}

}
