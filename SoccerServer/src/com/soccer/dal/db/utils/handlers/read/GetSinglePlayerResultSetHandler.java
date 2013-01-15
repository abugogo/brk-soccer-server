package com.soccer.dal.db.utils.handlers.read;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.db.utils.EntityFactory;
import com.soccer.entities.IDAOPlayer;

public class GetSinglePlayerResultSetHandler implements
		ResultSetHandler<IDAOPlayer> {
	public static final String QUERY = "SELECT u.id, u.fname, u.lname,"
			+ " u.tel1, u.tel2, u.email, u.bday, u.fb_user, u.occupation,"
			+ " u.address1, u.address2, p.description, u.P_img, p.Active, p.isAdmin"
			+ " FROM %s.players as p"
			+ " INNER JOIN abugogo_soccer_sys.users as u ON p.id=u.id"
			+ " WHERE id = ?";
	private static final GetSinglePlayerResultSetHandler instance = new GetSinglePlayerResultSetHandler();

	public static GetSinglePlayerResultSetHandler getInstance() {
		return instance;
	}

	public static String getQuery(String schema) {
		return String.format(QUERY, schema);
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
