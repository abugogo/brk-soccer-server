package com.soccer.actions.games;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.entities.EntityManager;
import com.soccer.entities.IDAOGame;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.lib.SoccerException;
import com.soccer.services.SoccerService;

public class GetGameAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req, HttpServletResponse resp) {
		String[] pathInfo = path.getPathArray();
		IDAOGame g = null;
		try {
			if (pathInfo != null && pathInfo.length == 2) {
				g = SoccerService.getInstance().getGame(pathInfo[1]);
			}
			
			EntityManager.writeGame(g, resp.getOutputStream());
			resp.setContentType("application/json");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SoccerException e) {
			e.printStackTrace();
		}

	}

}
