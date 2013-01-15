package com.soccer.dal.db.utils;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.soccer.entities.IDAOSeason;
import com.soccer.entities.IDAOUser;
import com.soccer.entities.impl.DAOGame;
import com.soccer.entities.impl.DAOLEvent;
import com.soccer.entities.impl.DAOPlayer;
import com.soccer.entities.impl.DAOPosition;
import com.soccer.entities.impl.DAOSeason;
import com.soccer.entities.impl.DAOUser;
import com.soccer.entities.impl.PrintableLineup;

public final class EntityFactory {
	public static DAOGame createGame(ResultSet rslt) throws SQLException {
		DAOGame game = new DAOGame();
		game.setGameId(rslt.getString("g.game_id"));
		game.setBgoals(rslt.getInt("g.bgoals"));
		game.setDescription(rslt.getString("g.description"));
		game.setGameDate(rslt.getDate("g.game_date"));
		game.setGameName(rslt.getString("g.game_name"));
		game.setHasDraft((byte) (rslt.getBoolean("g.has_draft") ? 1 : 0));
		game.setMisc(rslt.getString("g.misc"));
		game.setMore(rslt.getString("g.more"));
		game.setWgoals(rslt.getInt("g.wgoals"));
		game.setWinner(rslt.getString("g.winner"));
		return game;
	}

	public static PrintableLineup createLineup(ResultSet rslt) throws SQLException {
		PrintableLineup lineup = new PrintableLineup();
		lineup.setGameId(rslt.getString("g.game_id"));
		lineup.setPlayerId(rslt.getString("l.player_id"));
		lineup.setColor(rslt.getString("l.color"));
		lineup.setMisc(rslt.getString("l.misc"));
		lineup.setPoints(rslt.getShort("l.points"));
		return lineup;
	}

	public static DAOPlayer createPlayer(ResultSet rslt) throws SQLException {
		DAOPlayer player = new DAOPlayer();
		player.setId(rslt.getString("id"));
		player.setFname(rslt.getString("fname"));
		player.setLname(rslt.getString("lname"));
		player.setPositionBean(new DAOPosition());
		player.setTel1(rslt.getString("tel1"));
		player.setTel2(rslt.getString("tel2"));
		player.setEmail(rslt.getString("email"));
		player.setBday(rslt.getDate("bday"));
		player.setFbUser(rslt.getString("fb_user"));
		player.setOccupation(rslt.getString("occupation"));
		player.setAddress1(rslt.getString("address1"));
		player.setAddress2(rslt.getString("address2"));
		player.setDescription(rslt.getString("description"));
		player.setP_img(rslt.getString("P_img"));
		player.setActive(null);
		return player;
	}

	public static IDAOSeason createSeason(ResultSet rslt) throws SQLException {
		IDAOSeason season = new DAOSeason();
		season.setId(rslt.getInt("id"));
		season.setSdate(rslt.getDate("sdate"));
		season.setEdate(rslt.getDate("edate"));
		season.setMisc(rslt.getString("misc"));

		return season;
	}

	public static IDAOUser createUser(ResultSet rslt) throws SQLException {
		IDAOUser user = new DAOUser();
		user.setId(BigInteger.valueOf(rslt.getLong("id")));
		user.setFname(rslt.getString("fname"));
		user.setLname(rslt.getString("lname"));
		user.setTel1(rslt.getString("tel1"));
		user.setTel2(rslt.getString("tel2"));
		user.setEmail(rslt.getString("email"));
		user.setBday(rslt.getDate("bday"));
		user.setFbUser(rslt.getString("fb_user"));
		user.setOccupation(rslt.getString("occupation"));
		user.setAddress1(rslt.getString("address1"));
		user.setAddress2(rslt.getString("address2"));
		user.setP_img(rslt.getString("P_img"));
		return user;
	}

	public static DAOLEvent createLEvent(ResultSet rslt) throws SQLException {
		DAOLEvent evt = null;
		if (rslt.getBigDecimal("id") != null) {
			evt = new DAOLEvent();
			evt.setGameId(rslt.getString("gid"));
			evt.setPlayerId(rslt.getString("pid"));
			evt.setTime(rslt.getTime("time"));
			evt.setType(rslt.getInt("type"));
		}

		return evt;
	}
}
