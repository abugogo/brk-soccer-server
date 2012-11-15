package com.soccer.dal.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.soccer.actions.images.ImageContentType;
import com.soccer.dal.api.IGamesAPI;
import com.soccer.dal.api.IImageAPI;
import com.soccer.dal.api.IPlayersAPI;
import com.soccer.dal.api.ISeasonAPI;
import com.soccer.dal.api.ITableAPI;
import com.soccer.dal.api.IUsersAPI;
import com.soccer.dal.db.utils.handlers.GetGamesResultSetHandler;
import com.soccer.dal.db.utils.handlers.GetIImageResultHandler;
import com.soccer.dal.db.utils.handlers.GetPlayersResultSetHandler;
import com.soccer.dal.db.utils.handlers.GetSeasonsResultSetHandler;
import com.soccer.dal.db.utils.handlers.GetSingleGameResultSetHandler;
import com.soccer.dal.db.utils.handlers.GetSinglePlayerResultSetHandler;
import com.soccer.dal.db.utils.handlers.GetSingleSeasonResultSetHandler;
import com.soccer.dal.db.utils.handlers.GetTableResultSetHandler;
import com.soccer.dal.db.utils.handlers.GetWinLoseStripResultSetHandler;
import com.soccer.dal.db.utils.handlers.sys.CreateUserResultSetHandler;
import com.soccer.dal.db.utils.handlers.sys.GetSingleUserResultSetHandler;
import com.soccer.entities.IDAOGame;
import com.soccer.entities.IDAOPlayer;
import com.soccer.entities.IDAOSeason;
import com.soccer.entities.IDAOUser;
import com.soccer.entities.ITableRow;
import com.soccer.entities.IWinLoseStrip;
import com.soccer.entities.image.IImage;
import com.soccer.entities.impl.DAOLineup;

public class SqlDBDal implements IPlayersAPI, IGamesAPI, IImageAPI, ITableAPI, ISeasonAPI, IUsersAPI {
	private static final String INSERT_GAME = "INSERT INTO games_tbl " +
	"(game_name, game_date, winner, " +
	"wgoals, bgoals, has_draft, description, " +
	"misc, more) " + 
	"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String INSERT_LINEUP = "INSERT INTO lineup" +
	"(game_id, player_id, color, goal, " +
	"o_goal, points, misc) " +
	"VALUES (?,?,?,?,?,?,?)";
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
			return _queryRunner.query(GetPlayersResultSetHandler.QUERY, GetPlayersResultSetHandler.getInstance(), 1);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	@Override
	public List<IDAOGame> getGames() {
		try {

			return _queryRunner.query(GetGamesResultSetHandler.QUERY, GetGamesResultSetHandler.getInstance());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public IDAOPlayer getPlayer(String pid) {
		try {
			return _queryRunner.query(GetSinglePlayerResultSetHandler.QUERY, GetSinglePlayerResultSetHandler.getInstance(), pid);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public IDAOGame getGame(String gid) {
		try {
			return _queryRunner.query(GetSingleGameResultSetHandler.QUERY, GetSingleGameResultSetHandler.getInstance(), gid);
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
			Connection conn = _queryRunner.getDataSource().getConnection();
			conn.setAutoCommit(false);
			
			PreparedStatement stmt = conn.prepareStatement(INSERT_GAME, 
                    Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, "");
			stmt.setDate(2, new java.sql.Date(game.getGameDate().getTime()));
			stmt.setString(3, game.getWinner().toString());
			stmt.setInt(4, game.getWgoals());
			stmt.setInt(5, game.getBgoals());
			stmt.setInt(6, 0);
			stmt.setString(7, "");
			stmt.setString(8, "");
			stmt.setString(9, "");
			
			stmt.executeUpdate();
			ResultSet res = stmt.getGeneratedKeys();
			int game_id = 0;
			if (res.next())
				game_id = res.getInt(1);
			if(game_id != 0) {
				for (Iterator<DAOLineup> it = game.getLineup().iterator(); it.hasNext();) {
					DAOLineup lineup = it.next();
					_queryRunner.update(conn, 
							INSERT_LINEUP, game_id, lineup.getPlayerId(),
							lineup.getColor(), lineup.getGoal(), lineup.getOGoal(),
							lineup.getPoints(), lineup.getMisc());
				}
				conn.commit();
			}
			else
				conn.rollback();
			/*
			_queryRunner.update(conn,
					INSERT_GAME,
					game.getGameId(), game.getGameName(), game.getGameDate(), 
					game.getWinner(), game.getWgoals(), game.getBgoals(), 
					game.getHasDraft(), game.getDescription(), game.getMisc(), 
					game.getMore());
					*/
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

	@Override
	public void storeImage(String id, ImageContentType type, InputStream imgStream) {
		try {
			_queryRunner.update("INSERT INTO images (id, mime_type, image) VALUES (?, ?, ?)", id, type.getContentType(), imgStream);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public IImage readImage(String id) {
		try {
			return _queryRunner.query(GetIImageResultHandler.QUERY, GetIImageResultHandler.getInstance(), id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<IWinLoseStrip> getWinLoseStrips(String pid) {
		try {
			return _queryRunner.query(GetWinLoseStripResultSetHandler.QUERY, GetWinLoseStripResultSetHandler.getInstance(), pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ITableRow> getPlayersTable() {
		try {
			return _queryRunner.query(GetTableResultSetHandler.QUERY, GetTableResultSetHandler.getInstance());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public IDAOSeason getSeason(int id) {
		try {
			return _queryRunner.query(GetSingleSeasonResultSetHandler.QUERY, 
					GetSingleSeasonResultSetHandler.getInstance(), id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<IDAOSeason> getSeasons() {
		try {
			return _queryRunner.query(GetSeasonsResultSetHandler.QUERY, 
					GetSeasonsResultSetHandler.getInstance());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void createSeason(IDAOSeason season) {
		try {
			_queryRunner.update(
					" INSERT INTO seasons " +
					" (id, sdate, edate, misc) " +
					" VALUES (?, ?, ?, ?) ", 
					season.getId(), season.getSdate(), 
					season.getEdate(), season.getMisc());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public IDAOUser getUser(String u, String p) {
		try {
			return _queryRunner.query(GetSingleUserResultSetHandler.QUERY, GetSingleUserResultSetHandler.getInstance(), u, p);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int createUser(IDAOUser u, String salt) {
		try {
			return _queryRunner.update(CreateUserResultSetHandler.QUERY, u.getId().toString(), u.getPassword(), u.getFname(), "", u.getLname(),
					u.getTel1(), u.getTel2(), u.getEmail(), u.getBday(), u.getFbUser(), 
					u.getOccupation(), u.getAddress1(), u.getAddress2(), u.getP_img(), salt);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
