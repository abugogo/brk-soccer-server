package com.soccer.dal.db.utils.handlers.read;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import com.soccer.entities.IWinLoseStrip.GameResultType;
import com.soccer.entities.impl.WinLoseStrip;

public class GetWinLoseStripResultSetHandler implements
		ResultSetHandler<List<WinLoseStrip>> {

	public static final String QUERY = "SELECT LNP.color as c, GMS.game_date as d, GMS.winner as w "
			+ "FROM %s.lineup LNP "
			+ "  INNER JOIN %s.games_tbl GMS "
			+ "  ON LNP.game_id=GMS.game_id "
			+ "WHERE LNP.player_id = ? "
			+ "ORDER BY GMS.game_date";
	private static final GetWinLoseStripResultSetHandler instance = new GetWinLoseStripResultSetHandler();

	public static GetWinLoseStripResultSetHandler getInstance() {
		return instance;
	}

	public static String getQuery(String schema) {
		return String.format(QUERY, schema, schema);
	}

	@Override
	public List<WinLoseStrip> handle(ResultSet rslt) throws SQLException {
		List<WinLoseStrip> res = new LinkedList<WinLoseStrip>();
		WinLoseStrip strip = new WinLoseStrip(), lstrip = new WinLoseStrip(), wstrip = new WinLoseStrip();
		int counter = 0;
		boolean win_stripe = true, start = true;

		while (rslt.next()) {
			String winner = rslt.getString("w");
			String pcolor = rslt.getString("c");
			GameResultType type = (winner.equals("d") ? GameResultType.TIE
					: (pcolor.equals(winner) ? GameResultType.WIN
							: GameResultType.LOSE));

			if (start) {
				if (type != GameResultType.TIE) {
					start = false;
					counter = 1;
					if (type == GameResultType.WIN) {
						strip = initLineupStripe(GameResultType.WIN,
								rslt.getDate("d"));
						win_stripe = true;
					} else if (type == GameResultType.LOSE) {
						strip = initLineupStripe(GameResultType.LOSE,
								rslt.getDate("d"));
						win_stripe = false;
					}
				}
			} else {
				if (win_stripe) {
					if (type == GameResultType.WIN
							|| type == GameResultType.TIE) {
						counter++;
						strip.setEndDate(rslt.getDate("d"));
						strip.setNumber(counter);
					} else {
						if (strip.getNumber() > wstrip.getNumber()) {
							wstrip = strip;
						}
						strip = initLineupStripe(GameResultType.LOSE,
								rslt.getDate("d"));
						counter = 1;
						win_stripe = !win_stripe;
					}
				} else {
					if (type == GameResultType.LOSE
							|| type == GameResultType.TIE) {
						counter++;
						strip.setEndDate(rslt.getDate("d"));
						strip.setNumber(counter);
					} else {
						if (strip.getNumber() > lstrip.getNumber()) {
							lstrip = strip;
						}
						strip = initLineupStripe(GameResultType.WIN,
								rslt.getDate("d"));
						counter = 1;
						win_stripe = !win_stripe;
					}
				}
			}
		}

		// Add the last strip
		if (win_stripe && strip.getNumber() > wstrip.getNumber()) {
			wstrip = strip;
		} else if (!win_stripe && strip.getNumber() > lstrip.getNumber())
			lstrip = strip;
		res.add(wstrip);
		res.add(lstrip);
		
		return res;
	}

	private WinLoseStrip initLineupStripe(GameResultType type, Date date) {
		WinLoseStrip strip = new WinLoseStrip();
		strip.setType(type);
		strip.setStartDate(date);
		strip.setEndDate(date);
		strip.setNumber(1);
		return strip;
	}
}
