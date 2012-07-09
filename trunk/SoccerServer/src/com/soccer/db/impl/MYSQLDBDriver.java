package com.soccer.db.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.soccer.dal.db.api.IGamesAPI;
import com.soccer.dal.db.api.IPlayersAPI;
import com.soccer.dal.entities.api.IDAOGame;
import com.soccer.dal.entities.api.IDAOPlayer;
import com.soccer.dal.entities.impl.DAOGame;
import com.soccer.dal.entities.impl.DAOPlayer;
import com.soccer.db.utils.QueryUtils;

public class MYSQLDBDriver implements IPlayersAPI, IGamesAPI {
	public static final String DRIVER_STRING = "com.mysql.jdbc.Driver";
	public static final String DB_HOST = "localhost";
	public static final String DB_PORT = "3306";
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "";
	public static final String DB_NAME = "ellagal_soccer";

	protected static MYSQLDBDriver _inst = null;
	private static DataSource _datasource = null;
	private static Connection _conn = null;

	private MYSQLDBDriver() {

	}

	public static void initDB() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");

			_datasource = (DataSource) envContext.lookup("jdbc/SoccerServerDB");
			
			// Getting a connection object
			_conn = _datasource.getConnection();
			// Class.forName(sDriver);
			// _conn = DriverManager.getConnection(connStr, dbUser, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void initSQLDriver(MYSQLDBDriver inst) {
		try {
			initDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return _conn;

	}

	public DataSource getDS() {
		return _datasource;
	}

	synchronized public static MYSQLDBDriver getInst() {
		if (_inst == null) {
			_inst = new MYSQLDBDriver();
			initSQLDriver(_inst);
		}
		return (MYSQLDBDriver) _inst;
	}

	public List<IDAOPlayer> getActivePlayers() {
		List<IDAOPlayer> retList = new ArrayList<IDAOPlayer>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		try {

			list = QueryUtils.query(_datasource,
					"SELECT * FROM players WHERE Active=1");
			if (list != null) {
				Iterator<HashMap<String, Object>> itr = list.iterator();
				while (itr.hasNext()) {
					HashMap<String, Object> hm = (HashMap<String, Object>) itr
							.next();
					DAOPlayer p = new DAOPlayer(hm);
					retList.add(p);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return retList;
	}

	public List<IDAOGame> getGames() {
		List<IDAOGame> retList = new ArrayList<IDAOGame>();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		try {

			list = QueryUtils.query(_datasource, "SELECT * FROM games_tbl");
			Iterator<HashMap<String, Object>> itr = list.iterator();
			while (itr.hasNext()) {
				HashMap<String, Object> hm = (HashMap<String, Object>) itr
						.next();
				DAOGame p = new DAOGame(hm);
				retList.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return retList;
	}

	public IDAOPlayer getPlayer(String pid) {
		IDAOPlayer retP = new DAOPlayer();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		try {

			list = QueryUtils.query(_datasource,
					"SELECT * FROM players WHERE id=" + pid);
			Iterator<HashMap<String, Object>> itr = list.iterator();
			while (itr.hasNext()) {
				HashMap<String, Object> hm = (HashMap<String, Object>) itr
						.next();
				retP = new DAOPlayer(hm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return retP;
	}

	public IDAOGame getGame(String gid) {
		IDAOGame retG = new DAOGame();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		try {

			list = (ArrayList<HashMap<String, Object>>) QueryUtils
					.query(_datasource,
							"SELECT * FROM games_tbl WHERE game_id=" + gid);
			Iterator<HashMap<String, Object>> itr = list.iterator();
			while (itr.hasNext()) {
				HashMap<String, Object> hm = (HashMap<String, Object>) itr
						.next();
				retG = new DAOGame(hm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return retG;
	}

	public void createPlayer(IDAOPlayer p) {
		if (p != null && p.getId() != null) {
			String query = null;
			query = "INSERT INTO players (id, id_num, fname, lname, position, tel1, tel2, email, bday, fb_user, occupation, address1, address2, description, P_img, Active) VALUES (";
			query += (p.getId() + ",");
			query += (p.getIdNum() + ",");
			query += ("'" + p.getFname() + "',");
			query += ("'" + p.getLname() + "',");
			query += ("2,");
			query += ("'" + p.getTel1() + "',");
			query += ("'" + p.getTel2() + "',");
			query += ("'" + p.getEmail() + "',");
			query += ("'1971-06-28',");
			query += ("'" + p.getFbUser() + "',");
			query += ("'" + p.getOccupation() + "',");
			query += ("'" + p.getAddress1() + "',");
			query += ("'" + p.getAddress2() + "',");
			query += ("'" + p.getDescription() + "',");
			query += ("0,");
			query += ("1)");

			QueryUtils.update(getConnection(), query);
		}
	}

}
