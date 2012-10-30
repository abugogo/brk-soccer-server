package com.soccer.actions.games;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.entities.EntityManager;
import com.soccer.entities.IDAOGame;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.lib.SoccerException;
import com.soccer.services.SoccerService;

public class GetGamesAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req,
			HttpServletResponse resp) {
		List<IDAOGame> l = null;
		try {
			l = SoccerService.getInstance().getGames();
			EntityManager.writeGames(l, resp.getOutputStream());
			resp.setContentType("application/json");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SoccerException e) {
			e.printStackTrace();
		}

	}

}
