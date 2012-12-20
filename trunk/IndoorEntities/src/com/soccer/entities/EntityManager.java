package com.soccer.entities;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.soccer.entities.impl.DAOGame;
import com.soccer.entities.impl.DAOPlayer;
import com.soccer.entities.impl.DAOSeason;
import com.soccer.entities.impl.DAOUser;
import com.soccer.entities.impl.TableRow;
import com.soccer.entities.impl.WinLoseStrip;
import com.soccer.lib.SoccerException;

public class EntityManager {
	// is it thread safe?
	private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

	public static IDAOPlayer readPlayer(String str) {
		return gson.fromJson(str, DAOPlayer.class);
	}

	public static ArrayList<DAOPlayer> readPlayers(String str) {
		Type tListOfPlayers = new TypeToken<List<DAOPlayer>>(){}.getType();
		return gson.fromJson(str, tListOfPlayers);
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

	public static String writePlayers(List<DAOPlayer> players) {
		Type tListOfPlayers = new TypeToken<List<DAOPlayer>>(){}.getType();
		return gson.toJson(players, tListOfPlayers);
	}

	public static void writePlayersToStream(List<DAOPlayer> players,
			OutputStream out) throws SoccerException {
		try {
			Type tListOfPlayers = new TypeToken<List<DAOPlayer>>(){}.getType();
			out.write(gson.toJson(players, tListOfPlayers).getBytes());
		} catch (IOException e) {
			throw new SoccerException(
					"Could not write List of Players as JSON string", e);
		}
	}

	public static void writeWinLoseStripToStream(List<WinLoseStrip> strips,
			OutputStream out) throws SoccerException {
		try {
			Type tListOfStrips = new TypeToken<List<WinLoseStrip>>(){}.getType();
			out.write(gson.toJson(strips, tListOfStrips).getBytes());
		} catch (IOException e) {
			throw new SoccerException(
					"Could not write List of Players as JSON string", e);
		}
	}

	public static List<IWinLoseStrip> readPlayerStats(String str) {
		Type tListOfStrips = new TypeToken<List<WinLoseStrip>>(){}.getType();
		return gson.fromJson(str, tListOfStrips);
	}

	public static void writeTableToStream(List<TableRow> table,
			OutputStream out) throws SoccerException {
		try {
			Type tListOfTRow = new TypeToken<List<TableRow>>(){}.getType();
			out.write(gson.toJson(table, tListOfTRow).getBytes());
		} catch (IOException e) {
			throw new SoccerException("Could not write table as JSON string", e);
		}
	}

	public static List<ITableRow> readTable(String str) throws SoccerException {
		Type tListOfTRow = new TypeToken<List<TableRow>>(){}.getType();
		return gson.fromJson(str, tListOfTRow);
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

	public static String writeGames(List<DAOGame> games)
			throws SoccerException {
		Type tListOfGames = new TypeToken<List<DAOGame>>(){}.getType();
		return gson.toJson(games, tListOfGames);
	}

	public static void writeGames(List<DAOGame> games, OutputStream out)
			throws SoccerException {
		try {
			Type tListOfGames = new TypeToken<List<DAOGame>>(){}.getType();
			out.write(gson.toJson(games, tListOfGames).getBytes());
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

	public static String writeSeasons(List<DAOSeason> seasons)
			throws SoccerException {
		Type tListOfSeasons = new TypeToken<List<DAOSeason>>(){}.getType();
		return gson.toJson(seasons, tListOfSeasons);
	}

	public static void writeSeasons(List<IDAOSeason> seasons, OutputStream out)
			throws SoccerException {
		try {
			Type tListOfSeasons = new TypeToken<List<DAOSeason>>(){}.getType();
			out.write(gson.toJson(seasons, tListOfSeasons).getBytes());
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
