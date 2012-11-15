package com.soccer.entities;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.soccer.entities.impl.DAOGame;
import com.soccer.entities.impl.DAOPlayer;
import com.soccer.entities.impl.DAOSeason;
import com.soccer.entities.impl.DAOUser;
import com.soccer.entities.impl.TableRow;
import com.soccer.entities.impl.WinLoseStrip;
import com.soccer.lib.SoccerException;

public class EntityManager {
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static IDAOPlayer readPlayer(InputStream is) throws SoccerException {
		try {
			return mapper.readValue(is, DAOPlayer.class);
		} catch (IOException e) {
			throw new SoccerException("Could not create Player from Input Stream", e);
		}
	}
	
	public static IDAOPlayer readPlayer(String str) throws SoccerException {
		try {
			return mapper.readValue(str.getBytes(), DAOPlayer.class);
		} catch (IOException e) {
			throw new SoccerException("Could not create Player from String", e);
		}
	}
	
	public static ArrayList<IDAOPlayer> readPlayers(String str) throws SoccerException {
		try {
			return mapper.readValue(str.getBytes(), new TypeReference<ArrayList<DAOPlayer>>(){});
		} catch (IOException e) {
			throw new SoccerException("Could not create Player from Input Stream", e);
		}
	}

	public static String writePlayer(IDAOPlayer player) throws SoccerException {
		try {
			return mapper.writeValueAsString(player);
		} catch (IOException e) {
			throw new SoccerException("Could not write Player to a JSON string", e);
		}
	}

	
	public static void writePlayerToStream(IDAOPlayer player, OutputStream out) throws SoccerException {
		try {
			mapper.writeValue(out, player);
		} catch (IOException e) {
			throw new SoccerException("Could not write Player to a JSON string", e);
		}
	}
	
	public static String writePlayers(List<IDAOPlayer> players) throws SoccerException {
		try {
			return mapper.writeValueAsString(players);
		} catch (IOException e) {
			throw new SoccerException("Could not write List of Players as JSON string", e);
		}
	}

	public static void writePlayersToStream(List<IDAOPlayer> players, OutputStream out) throws SoccerException {
		try {
			mapper.writeValue(out, players);
		} catch (IOException e) {
			throw new SoccerException("Could not write List of Players as JSON string", e);
		}
	}
	
	public static void writeWinLoseStripToStream(List<IWinLoseStrip> strips, OutputStream out) throws SoccerException {
		try {
			mapper.writeValue(out, strips);
		} catch (IOException e) {
			throw new SoccerException("Could not write List<IWinLoseStrip> to OutputStream", e);
		}
	}
	
	public static List<IWinLoseStrip> readPlayerStats(String str) throws SoccerException {
		try {
			return mapper.readValue(str.getBytes(), new TypeReference<ArrayList<WinLoseStrip>>(){});
		} catch (IOException e) {
			throw new SoccerException("Could not create Player stats from Input Stream", e);
		}
	}

	public static void writeTableToStream(List<ITableRow> table, OutputStream out) throws SoccerException {
		try {
			mapper.writeValue(out, table);
		} catch (IOException e) {
			throw new SoccerException("Could not write List<ITableRow> to OutputStream", e);
		}
	}
	
	public static List<ITableRow> readTable(String str) throws SoccerException {
		try {
			return mapper.readValue(str.getBytes(), new TypeReference<ArrayList<TableRow>>(){});
		} catch (IOException e) {
			throw new SoccerException("Could not create Player stats from Input Stream", e);
		}
	}
	
	public static IDAOGame readGame(InputStream is) throws SoccerException {
		try {
			return mapper.readValue(is, DAOGame.class);
		} catch (IOException e) {
			throw new SoccerException("Could not read game from input stream", e);
		}
	}
	
	public static IDAOGame readGame(String str) throws SoccerException {
		try {
			return mapper.readValue(str.getBytes(), DAOGame.class);
		} catch (IOException e) {
			throw new SoccerException("Could not read game from string", e);
		}
	}

	public static String writeGame(IDAOGame game) throws SoccerException {
		try {
			return mapper.writeValueAsString(game);
		} catch (IOException e) {
			throw new SoccerException("Could not write a Game to a JSON string", e);
		}
	}

	public static void writeGame(IDAOGame game, OutputStream out) throws SoccerException {
		try {
			mapper.writeValue(out, game);
		} catch (IOException e) {
			throw new SoccerException("Could not write a Game to a JSON string", e);
		}
	}
	
	public static String writeGames(List<IDAOGame> games) throws SoccerException {
		try {
			return mapper.writeValueAsString(games);
		} catch (IOException e) {
			throw new SoccerException("Could not write List of Games as JSON string", e);
		}
	}
	
	public static void writeGames(List<IDAOGame> games, OutputStream out) throws SoccerException {
		try {
			mapper.writeValue(out, games);
		} catch (IOException e) {
			throw new SoccerException("Could not write List of Games as JSON string", e);
		}
	}

	public static DAOSeason readSeason(InputStream is) throws SoccerException {
		try {
			return mapper.readValue(is, DAOSeason.class);
		} catch (IOException e) {
			throw new SoccerException("Could not read Season from input stream", e);
		}
	}
	
	public static DAOSeason readSeason(String str) throws SoccerException {
		try {
			return mapper.readValue(str.getBytes(), DAOSeason.class);
		} catch (IOException e) {
			throw new SoccerException("Could not read Season from string", e);
		}
	}

	public static String writeSeason(IDAOSeason season) throws SoccerException {
		try {
			return mapper.writeValueAsString(season);
		} catch (IOException e) {
			throw new SoccerException("Could not write a Season to a JSON string", e);
		}
	}

	public static void writeSeason(IDAOSeason season, OutputStream out) throws SoccerException {
		try {
			mapper.writeValue(out, season);
		} catch (IOException e) {
			throw new SoccerException("Could not write a Season to a JSON string", e);
		}
	}
	
	public static String writeSeasons(List<IDAOSeason> seasons) throws SoccerException {
		try {
			return mapper.writeValueAsString(seasons);
		} catch (IOException e) {
			throw new SoccerException("Could not write List of Seasons as JSON string", e);
		}
	}
	
	public static void writeSeasons(List<IDAOSeason> seasons, OutputStream out) throws SoccerException {
		try {
			mapper.writeValue(out, seasons);
		} catch (IOException e) {
			throw new SoccerException("Could not write List of Seasons as JSON string", e);
		}
	}
	
	public static IDAOUser readUser(InputStream is) throws SoccerException {
		try {
			return mapper.readValue(is, DAOUser.class);
		} catch (IOException e) {
			throw new SoccerException("Could not create User from Input Stream", e);
		}
	}
	
}
