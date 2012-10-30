package com.soccer.dal.db.utils.handlers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.dal.db.utils.EntityFactory;
import com.soccer.entities.IDAOSeason;

public class GetSeasonsResultSetHandler implements ResultSetHandler<List<IDAOSeason>> {
	public static String QUERY = 
			" SELECT id, sdate, edate, misc " +
			" FROM seasons " +
			" ORDER BY sdate DESC ";
	private static GetSeasonsResultSetHandler instance = new GetSeasonsResultSetHandler();
	
	public static GetSeasonsResultSetHandler getInstance() {
		return instance;
	}

	@Override
	public List<IDAOSeason> handle(ResultSet rslt) throws SQLException {
		List<IDAOSeason> seasons = new ArrayList<IDAOSeason>();
		while (rslt.next()) {
			IDAOSeason season = EntityFactory.createSeason(rslt);
			seasons.add(season);
		}
		return seasons;
	}

}