package com.soccer.entities;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.soccer.entities.impl.DAOGame;
import com.soccer.entities.impl.DAOPlayer;
import com.soccer.entities.impl.DAOSeason;
import com.soccer.entities.impl.DAOUser;
import com.soccer.entities.impl.TableRow;
import com.soccer.entities.impl.WinLoseStrip;
import com.soccer.lib.SoccerException;

public class EntityManager {
	// is it thread safe?
	private static Gson gson = new Gson();

	public static IDAOPlayer readPlayer(String str) {
		return gson.fromJson(str, DAOPlayer.class);
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<IDAOPlayer> readPlayers(String str) {
		return gson.fromJson(str, (new ArrayList<DAOPlayer>()).getClass());
	}

	public static String writePlayer(IDAOPlayer player) throws SoccerException {
		return gson.toJson(player);
	}

	public static void writePlayerToStream(IDAOPlayer player, OutputStream out)
			throws SoccerException {
		try {
			out.write(gson.toJson(player).getBytes());
		} catch (IOException e) {
			throw new SoccerException("Could not write player as JSON string",
					e);
		}
	}

	public static String writePlayers(List<IDAOPlayer> players) {
		return gson.toJson(players);
	}

	public static void writePlayersToStream(List<IDAOPlayer> players,
			OutputStream out) throws SoccerException {
		try {
			out.write(gson.toJson(players).getBytes());
		} catch (IOException e) {
			throw new SoccerException(
					"Could not write List of Players as JSON string", e);
		}
	}

	public static void writeWinLoseStripToStream(List<IWinLoseStrip> strips,
			OutputStream out) throws SoccerException {
		try {
			out.write(gson.toJson(strips).getBytes());
		} catch (IOException e) {
			throw new SoccerException(
					"Could not write List of Players as JSON string", e);
		}
	}

	@SuppressWarnings("unchecked")
	public static List<IWinLoseStrip> readPlayerStats(String str) {
		return gson.fromJson(str, (new ArrayList<WinLoseStrip>()).getClass());
	}

	public static void writeTableToStream(List<ITableRow> table,
			OutputStream out) throws SoccerException {
		try {
			out.write(gson.toJson(table).getBytes());
		} catch (IOException e) {
			throw new SoccerException("Could not write table as JSON string", e);
		}
	}

	@SuppressWarnings("unchecked")
	public static List<ITableRow> readTable(String str) throws SoccerException {
		return gson.fromJson(str, (new ArrayList<TableRow>()).getClass());
	}

	public static IDAOGame readGame(String str) {
		return gson.fromJson(str, DAOGame.class);
	}

	public static String writeGame(IDAOGame game) {
		return gson.toJson(game);
	}

	public static void writeGame(IDAOGame game, OutputStream out)
			throws SoccerException {
		try {
			out.write(gson.toJson(game).getBytes());
		} catch (IOException e) {
			throw new SoccerException("Could not write game as JSON string", e);
		}
	}

	public static String writeGames(List<IDAOGame> games)
			throws SoccerException {
		return gson.toJson(games);
	}

	public static void writeGames(List<IDAOGame> games, OutputStream out)
			throws SoccerException {
		try {
			out.write(gson.toJson(games).getBytes());
		} catch (IOException e) {
			throw new SoccerException(
					"Could not write List of games as JSON string", e);
		}
	}

	public static DAOSeason readSeason(String str) {
		return gson.fromJson(str, DAOSeason.class);
	}

	public static String writeSeason(IDAOSeason season) {
		return gson.toJson(season);
	}

	public static void writeSeason(IDAOSeason season, OutputStream out)
			throws SoccerException {
		try {
			out.write(gson.toJson(season).getBytes());
		} catch (IOException e) {
			throw new SoccerException("Could not write season as JSON string",
					e);
		}
	}

	public static String writeSeasons(List<IDAOSeason> seasons)
			throws SoccerException {
		return gson.toJson(seasons);
	}

	public static void writeSeasons(List<IDAOSeason> seasons, OutputStream out)
			throws SoccerException {
		try {
			out.write(gson.toJson(seasons).getBytes());
		} catch (IOException e) {
			throw new SoccerException(
					"Could not write List of seasons as JSON string", e);
		}
	}

	public static IDAOUser readUser(String str) {
		return gson.fromJson(str, DAOUser.class);
	}

	public static void writeUserToStream(IDAOUser user, OutputStream out)
			throws SoccerException {
		try {
			out.write(gson.toJson(user).getBytes());
		} catch (IOException e) {
			throw new SoccerException(
					"Could not write user as JSON string", e);
		}
	}

}
