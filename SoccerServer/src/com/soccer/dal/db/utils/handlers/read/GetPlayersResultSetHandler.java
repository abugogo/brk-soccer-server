package com.soccer.dal.db.utils.handlers.read;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.db.utils.EntityFactory;
import com.soccer.entities.impl.DAOPlayer;

public class GetPlayersResultSetHandler implements
		ResultSetHandler<List<DAOPlayer>> {
	public static final String QUERY = "SELECT u.id, u.fname, u.lname,"
			+ "u.tel1, u.tel2, u.email, u.bday, u.fb_user, u.occupation,"
			+ "u.address1, u.address2, p.description, u.P_img, p.Active"
			+ " FROM %s.players as p"
			+ " INNER JOIN abugogo_soccer_sys.users as u ON p.id=u.id";
	public static final String QUERY_ACTIVE = " WHERE p.Active = ?";

	private static final GetPlayersResultSetHandler instance = new GetPlayersResultSetHandler();

	public static GetPlayersResultSetHandler getInstance() {
		return instance;
	}

	public static String getQuery(String schema, boolean active) {
		if (active)
			return String.format(QUERY, schema).concat(QUERY_ACTIVE);
		return String.format(QUERY, schema);
	}

	@Override
	public List<DAOPlayer> handle(ResultSet rslt) throws SQLException {
		List<DAOPlayer> players = new ArrayList<DAOPlayer>();
		while (rslt.next()) {
			players.add(EntityFactory.createPlayer(rslt));
		}
		return players;
	}

}
