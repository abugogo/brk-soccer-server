package com.soccer.dal.db;

import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.soccer.dal.api.IGamesAPI;
import com.soccer.dal.api.IPlayersAPI;
import com.soccer.dal.db.utils.handlers.GetGamesResultSetHandler;
import com.soccer.dal.db.utils.handlers.GetPlayersResultSetHandler;
import com.soccer.dal.db.utils.handlers.GetSingleGameResultSetHandler;
import com.soccer.dal.db.utils.handlers.GetSinglePlayerResultSetHandler;
import com.soccer.entities.IDAOGame;
import com.soccer.entities.IDAOPlayer;

public class SqlDBDal implements IPlayersAPI, IGamesAPI {
	protected static SqlDBDal _inst = null;
	private static DataSource _datasource = null;
	private static QueryRunner _queryRunner = null;

	private SqlDBDal() {

	}

	public static void initDB() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");

			_datasource = (DataSource) envContext.lookup("jdbc/SoccerServerDB");
			_queryRunner = new QueryRunner(_datasource);
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

	synchronized public static SqlDBDal getInst() {
		if (_inst == null) {
			_inst = new SqlDBDal();
			initSQLDriver(_inst);
		}
		return _inst;
	}

	@Override
	public List<IDAOPlayer> getActivePlayers() {
		try {
			return _queryRunner.query(GetPlayersResultSetHandler.QUERY, new GetPlayersResultSetHandler(), 1);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	@Override
	public List<IDAOGame> getGames() {
		try {

			return _queryRunner.query(GetGamesResultSetHandler.QUERY, new GetGamesResultSetHandler());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public IDAOPlayer getPlayer(String pid) {
		try {
			return _queryRunner.query(GetSinglePlayerResultSetHandler.QUERY, new GetSinglePlayerResultSetHandler(), pid);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public IDAOGame getGame(String gid) {
		try {
			return _queryRunner.query(GetSingleGameResultSetHandler.QUERY, new GetSingleGameResultSetHandler(), gid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void createPlayer(IDAOPlayer p) {
		try {
			_queryRunner.update("INSERT INTO players " +
					"(id, id_num, fname, lname, position, " +
					"tel1, tel2, email, bday, fb_user, " +
					"occupation, address1, address2, " +
					"description, P_img, Active) " +
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 
					p.getId(), p.getIdNum(), p.getFname(), p.getLname(), (p.getPositionBean()==null)?null:p.getPositionBean().getId(), p.getTel1(), 
					p.getTel2(), p.getEmail(), p.getBday(), p.getFbUser(), p.getOccupation(), p.getAddress1(), p.getAddress2(), p.getDescription(), p.getP_img(), 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createGame(IDAOGame game) {
		try {
			_queryRunner.update("INSERT INTO games_tbl " +
					"(game_id, game_name, game_date, winner, " +
					"wgoals, bgoals, has_draft, description, " +
					"misc, more) " + 
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
					game.getGameId(), game.getGameName(), game.getGameDate(), 
					game.getWinner(), game.getWgoals(), game.getBgoals(), 
					game.getHasDraft(), game.getDescription(), game.getMisc(), 
					game.getMore());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePlayer(IDAOPlayer p) {
		try {
			_queryRunner.update("UPDATE players " +
					"SET id_num = ?, " +
					"fname = ?, " +
					"lname = ?, " +
					"position = ?, " +
					"tel1 = ?, " +
					"tel2 = ?, " +
					"email = ?, " +
					"bday = ?, " +
					"fb_user = ?, " +
					"occupation = ?, " +
					"address1 = ?, " +
					"address2 = ?, " +
					"description = ?, " +
					"P_img = ? " +
					"WHERE id = ?", 
					p.getIdNum(), p.getFname(), p.getLname(), (p.getPositionBean()==null)?null:p.getPositionBean().getId(), p.getTel1(), 
					p.getTel2(), p.getEmail(), p.getBday(), p.getFbUser(), p.getOccupation(), p.getAddress1(), p.getAddress2(), p.getDescription(), p.getP_img(), p.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
