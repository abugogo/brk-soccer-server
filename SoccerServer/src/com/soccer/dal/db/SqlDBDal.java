package com.soccer.dal.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.soccer.dal.db.api.IGamesAPI;
import com.soccer.dal.db.api.IPlayersAPI;
import com.soccer.dal.db.utils.QueryUtils;
import com.soccer.dal.db.utils.handlers.GetGamesResultSetHandler;
import com.soccer.dal.db.utils.handlers.GetPlayersResultSetHandler;
import com.soccer.dal.db.utils.handlers.GetSingleGameResultSetHandler;
import com.soccer.dal.db.utils.handlers.GetSinglePlayerResultSetHandler;
import com.soccer.entities.IDAOGame;
import com.soccer.entities.IDAOPlayer;

public class SqlDBDal implements IPlayersAPI, IGamesAPI {
	protected static SqlDBDal _inst = null;
	private static DataSource _datasource = null;
	private static Connection _conn = null;
	private static QueryRunner _queryRunner = null;

	private SqlDBDal() {

	}

	public static void initDB() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");

			_datasource = (DataSource) envContext.lookup("jdbc/SoccerServerDB");
			_queryRunner = new QueryRunner(_datasource);
			
			// Getting a connection object
			_conn = _datasource.getConnection();
			// Class.forName(sDriver);
			// _conn = DriverManager.getConnection(connStr, dbUser, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void initSQLDriver(SqlDBDal inst) {
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

	synchronized public static SqlDBDal getInst() {
		if (_inst == null) {
			_inst = new SqlDBDal();
			initSQLDriver(_inst);
		}
		return _inst;
	}

	public List<IDAOPlayer> getActivePlayers() {
		try {
			return _queryRunner.query(GetPlayersResultSetHandler.QUERY, new GetPlayersResultSetHandler(), 1);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public List<IDAOGame> getGames() {
		try {

			return _queryRunner.query(GetGamesResultSetHandler.QUERY, new GetGamesResultSetHandler());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public IDAOPlayer getPlayer(String pid) {
		try {
			return _queryRunner.query(GetSinglePlayerResultSetHandler.QUERY, new GetSinglePlayerResultSetHandler(), pid);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public IDAOGame getGame(String gid) {
		try {
			return _queryRunner.query(GetSingleGameResultSetHandler.QUERY, new GetSingleGameResultSetHandler(), gid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
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
