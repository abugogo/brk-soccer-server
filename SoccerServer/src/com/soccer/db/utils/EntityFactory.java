package com.soccer.db.utils;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.soccer.dal.entities.api.IDAOGame;
import com.soccer.dal.entities.api.IDAOPlayer;
import com.soccer.dal.entities.impl.DAOGame;
import com.soccer.dal.entities.impl.DAOPlayer;
import com.soccer.dal.entities.impl.DAOPosition;

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
		IDAOPlayer palyer = new DAOPlayer();
		palyer.setId(rslt.getString("id"));
		palyer.setIdNum(BigInteger.valueOf(rslt.getLong("id_num")));
		palyer.setFname(rslt.getString("fname"));
		palyer.setLname(rslt.getString("lname"));
		palyer.setPositionBean(new DAOPosition());
		palyer.setTel1(rslt.getString("tel1"));
		palyer.setTel2(rslt.getString("tel2"));
		palyer.setEmail(rslt.getString("email"));
		palyer.setBday(rslt.getDate("bday"));
		palyer.setFbUser(rslt.getString("fb_user"));
		palyer.setOccupation(rslt.getString("occupation"));
		palyer.setAddress1(rslt.getString("address1"));
		palyer.setAddress2(rslt.getString("address2"));
		palyer.setDescription(rslt.getString("description"));
		palyer.setP_img(null);
		palyer.setActive(null);

		// TODO Auto-generated method stub
		return null;
	}
}
