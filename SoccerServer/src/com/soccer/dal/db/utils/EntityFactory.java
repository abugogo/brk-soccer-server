package com.soccer.dal.db.utils;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.soccer.entities.IDAOGame;
import com.soccer.entities.IDAOPlayer;
import com.soccer.entities.impl.DAOGame;
import com.soccer.entities.impl.DAOPlayer;
import com.soccer.entities.impl.DAOPosition;

public final class EntityFactory {
	public static IDAOGame createGame(ResultSet rslt) throws SQLException {
		DAOGame game = new DAOGame();
		game.setGameId(rslt.getString("game_id"));
		game.setBgoals(rslt.getInt("bgoals"));
		game.setDescription(rslt.getString("description"));
		game.setGameDate(rslt.getDate("game_date"));
		game.setGameName(rslt.getString("game_name"));
		game.setHasDraft((byte)(rslt.getBoolean("has_draft")?1:0));
		game.setMisc(rslt.getString("misc"));
		game.setMore(rslt.getString("more"));
		game.setWgoals(rslt.getInt("wgoals"));
		game.setWinner(rslt.getString("winner"));
		return game;
	}

	public static IDAOPlayer createPlayer(ResultSet rslt) throws SQLException {
		IDAOPlayer player = new DAOPlayer();
		player.setId(rslt.getString("id"));
		player.setIdNum(BigInteger.valueOf(rslt.getLong("id_num")));
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
		player.setP_img(null);
		player.setActive(null);
		return player;
	}
}
