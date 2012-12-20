package com.soccer.actions.players.stats;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.entities.EntityManager;
import com.soccer.entities.impl.WinLoseStrip;
import com.soccer.http.ContentType;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.lib.SoccerException;
import com.soccer.services.SoccerService;

public class GetPlayerStatsAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req, HttpServletResponse resp) {
		try {
			String playerId = path.getPathArray()[1];
			List<WinLoseStrip> strips = SoccerService.getInstance().getWinLoseStrips(playerId);
			EntityManager.writeWinLoseStripToStream(strips, resp.getOutputStream());
			resp.setContentType(ContentType.JSON.getType());
		} catch (SoccerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
