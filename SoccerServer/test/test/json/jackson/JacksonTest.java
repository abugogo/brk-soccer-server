package test.json.jackson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.soccer.entities.EntityManager;
import com.soccer.entities.IDAOGame;
import com.soccer.entities.impl.DAOGame;
import com.soccer.entities.impl.DAOLineup;
import com.soccer.lib.SoccerException;

public class JacksonTest {
	private static final String _123459324 = "123459324";

	@Test
	public void testDAOGame() {
		List<DAOLineup> lineup = new ArrayList<DAOLineup>();
		IDAOGame game = new DAOGame();
		game.setBgoals(5);
		game.setDescription("Game desc");
		game.setGameDate(new Date());
		game.setGameId(_123459324);
		game.setGameName("gmae name....");
		game.setWgoals(3);
		game.setWinner("b");
		game.setLineup(lineup);

		DAOLineup l = new DAOLineup();
		l.setColor("b");
		l.setGameId(_123459324);
		l.setGoal(5);
		l.setPlayerId("5");
		l.setPoints((short) 3);
		lineup.add(l);

		l = new DAOLineup();
		l.setColor("w");
		l.setGameId(_123459324);
		l.setGoal(3);
		l.setPlayerId("6");
		l.setPoints((short) 0);
		lineup.add(l);

		String data = "";
		data = EntityManager.writeGame(game);
		System.out.println(data);
		IDAOGame game2 = EntityManager.readGame(data);
		if (game2.getLineup().get(1).getGoal() == 3) {
			System.out.println("Read the game correctly");
		} else {
			System.out.println("Did *not* read the game correctly");
		}

	}
}
