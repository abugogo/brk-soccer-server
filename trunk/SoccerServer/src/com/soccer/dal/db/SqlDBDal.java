package com.soccer.dal.db;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.soccer.actions.images.ImageContentType;
import com.soccer.dal.api.IGamesAPI;
import com.soccer.dal.api.IImageAPI;
import com.soccer.dal.api.IPlayersAPI;
import com.soccer.dal.api.ISchemaAPI;
import com.soccer.dal.api.ISeasonAPI;
import com.soccer.dal.api.ITableAPI;
import com.soccer.dal.api.IUsersAPI;
import com.soccer.dal.db.utils.handlers.create.CreateGameHandler;
import com.soccer.dal.db.utils.handlers.create.CreatePlayerResultSetHandler;
import com.soccer.dal.db.utils.handlers.create.CreateSeasonResultSetHandler;
import com.soccer.dal.db.utils.handlers.read.GetGamesResultSetHandler;
import com.soccer.dal.db.utils.handlers.read.GetIImageResultHandler;
import com.soccer.dal.db.utils.handlers.read.GetPlayersResultSetHandler;
import com.soccer.dal.db.utils.handlers.read.GetSeasonsResultSetHandler;
import com.soccer.dal.db.utils.handlers.read.GetSingleGameResultSetHandler;
import com.soccer.dal.db.utils.handlers.read.GetSinglePlayerResultSetHandler;
import com.soccer.dal.db.utils.handlers.read.GetSingleSeasonResultSetHandler;
import com.soccer.dal.db.utils.handlers.read.GetTableResultSetHandler;
import com.soccer.dal.db.utils.handlers.read.GetWinLoseStripResultSetHandler;
import com.soccer.dal.db.utils.handlers.sys.CreateUserResultSetHandler;
import com.soccer.dal.db.utils.handlers.sys.GetSingleUserResultSetHandler;
import com.soccer.dal.db.utils.handlers.sys.GetUserPasswordResultSetHandler;
import com.soccer.dal.db.utils.handlers.sys.GetUserSaltResultSetHandler;
import com.soccer.dal.db.utils.handlers.sys.IsUserInAccountResultSetHandler;
import com.soccer.dal.db.utils.handlers.sys.UpdateUserResultSetHandler;
import com.soccer.dal.db.utils.handlers.update.UpdatePlayerResultSetHandler;
import com.soccer.entities.IDAOGame;
import com.soccer.entities.IDAOPlayer;
import com.soccer.entities.IDAOSeason;
import com.soccer.entities.IDAOUser;
import com.soccer.entities.ITableRow;
import com.soccer.entities.IWinLoseStrip;
import com.soccer.entities.image.IImage;
import com.soccer.http.context.RequestContext;
import com.soccer.http.cookie.CookieGen;

public class SqlDBDal implements IPlayersAPI, IGamesAPI, IImageAPI, ITableAPI,
		ISeasonAPI, IUsersAPI, ISchemaAPI {
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
			String schema = (String) RequestContext
					.getAttribute(RequestContext.REQ_CONTEXT);
			return _queryRunner.query(
					GetPlayersResultSetHandler.getQuery(schema, true),
					GetPlayersResultSetHandler.getInstance(), 1);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<IDAOPlayer> getPlayers() {
		try {
			String schema = (String) RequestContext
					.getAttribute(RequestContext.REQ_CONTEXT);
			return _queryRunner.query(
					GetPlayersResultSetHandler.getQuery(schema, false),
					GetPlayersResultSetHandler.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<IDAOGame> getGames() {
		try {
			String schema = (String) RequestContext
					.getAttribute(RequestContext.REQ_CONTEXT);

			return _queryRunner.query(
					GetGamesResultSetHandler.getQuery(schema),
					GetGamesResultSetHandler.getInstance());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public IDAOPlayer getPlayer(String pid) {
		try {
			String schema = (String) RequestContext
					.getAttribute(RequestContext.REQ_CONTEXT);
			return _queryRunner.query(
					GetSinglePlayerResultSetHandler.getQuery(schema),
					GetSinglePlayerResultSetHandler.getInstance(), pid);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public IDAOGame getGame(String gid) {
		try {
			String schema = (String) RequestContext
					.getAttribute(RequestContext.REQ_CONTEXT);
			return _queryRunner.query(
					GetSingleGameResultSetHandler.getQuery(schema),
					GetSingleGameResultSetHandler.getInstance(), gid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int createPlayer(IDAOPlayer p) {
		try {
			String schema = (String) RequestContext
					.getAttribute(RequestContext.REQ_CONTEXT);
			return _queryRunner.update(CreatePlayerResultSetHandler
					.getQuery(schema), p.getId(),
					(p.getPositionBean() == null) ? null : p.getPositionBean()
							.getId(), p.getDescription(), 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int createGame(IDAOGame game) {
		return CreateGameHandler.handle(_queryRunner, game);
	}

	@Override
	public int updatePlayer(IDAOPlayer p) {
		try {
			String schema = (String) RequestContext
					.getAttribute(RequestContext.REQ_CONTEXT);
			_queryRunner.update(UpdatePlayerResultSetHandler.getQuery(schema),
					(p.getPositionBean() == null) ? null : p.getPositionBean()
							.getId(), p.getDescription(), p.getActive(), p
							.getId());
			return _queryRunner.update(UpdateUserResultSetHandler.getQuery(),
					p.getFname(), p.getLname(), p.getTel1(), p.getTel2(),
					p.getEmail(), p.getBday(), p.getFbUser(),
					p.getOccupation(), p.getAddress1(), p.getAddress2(),
					p.getP_img(), p.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void storeImage(String id, ImageContentType type,
			InputStream imgStream) {
		try {
			_queryRunner
					.update("INSERT INTO images (id, mime_type, image) VALUES (?, ?, ?)",
							id, type.getContentType(), imgStream);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public IImage readImage(String id) {
		try {
			String schema = (String) RequestContext
					.getAttribute(RequestContext.REQ_CONTEXT);
			return _queryRunner.query(GetIImageResultHandler.getQuery(schema),
					GetIImageResultHandler.getInstance(), id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<IWinLoseStrip> getWinLoseStrips(String pid) {
		try {
			String schema = (String) RequestContext
					.getAttribute(RequestContext.REQ_CONTEXT);
			return _queryRunner.query(
					GetWinLoseStripResultSetHandler.getQuery(schema),
					GetWinLoseStripResultSetHandler.getInstance(), pid);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ITableRow> getPlayersTable() {
		try {
			String schema = (String) RequestContext
					.getAttribute(RequestContext.REQ_CONTEXT);
			return _queryRunner.query(
					GetTableResultSetHandler.getQuery(schema),
					GetTableResultSetHandler.getInstance());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public IDAOSeason getSeason(int id) {
		try {
			String schema = (String) RequestContext
					.getAttribute(RequestContext.REQ_CONTEXT);
			return _queryRunner.query(
					GetSingleSeasonResultSetHandler.getQuery(schema),
					GetSingleSeasonResultSetHandler.getInstance(), id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<IDAOSeason> getSeasons() {
		try {
			String schema = (String) RequestContext
					.getAttribute(RequestContext.REQ_CONTEXT);
			return _queryRunner.query(
					GetSeasonsResultSetHandler.getQuery(schema),
					GetSeasonsResultSetHandler.getInstance());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int createSeason(IDAOSeason season) {
		try {
			String schema = (String) RequestContext
					.getAttribute(RequestContext.REQ_CONTEXT);
			return _queryRunner.update(
					CreateSeasonResultSetHandler.getQuery(schema),
					season.getId(), season.getSdate(), season.getEdate(),
					season.getMisc());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public IDAOUser getUser(String u, String p) {
		try {
			String encPwd = CookieGen.encodeString(p.concat(getUserSalt(u)));
			return _queryRunner.query(GetSingleUserResultSetHandler.getQuery(),
					GetSingleUserResultSetHandler.getInstance(), u, encPwd);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int createUser(IDAOUser u, String salt) {
		try {
			String encPwd = CookieGen
					.encodeString(u.getPassword().concat(salt));
			return _queryRunner.update(CreateUserResultSetHandler.getQuery(), u
					.getId().toString(), encPwd, u.getFname(), u.getLname(), u
					.getTel1(), u.getTel2(), u.getEmail(), u.getBday(), u
					.getFbUser(), u.getOccupation(), u.getAddress1(), u
					.getAddress2(), u.getP_img(), salt);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public String getUserSalt(String u) {
		try {
			return _queryRunner.query(GetUserSaltResultSetHandler.getQuery(),
					GetUserSaltResultSetHandler.getInstance(), u);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// TODO - both methods getUserSalt and getUserPassword practically return
	// data for a certain field-can be merged into a generic method
	@Override
	public String getUserPassword(String u) {
		try {
			return _queryRunner.query(
					GetUserPasswordResultSetHandler.getQuery(),
					GetUserPasswordResultSetHandler.getInstance(), u);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean isUserInAccount(String uid, String acc) {
		try {
			return _queryRunner.query(
					IsUserInAccountResultSetHandler.getQuery(),
					IsUserInAccountResultSetHandler.getInstance(), uid, acc);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
