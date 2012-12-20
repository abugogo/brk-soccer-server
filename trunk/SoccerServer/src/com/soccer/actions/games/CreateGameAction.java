package com.soccer.actions.games;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.entities.EntityManager;
import com.soccer.entities.IDAOGame;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.services.SoccerService;

public class CreateGameAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req,
			HttpServletResponse resp) {
		IDAOGame game = EntityManager.readGame(req.getParameter("JSON"));
		SoccerService.getInstance().createGame(game);
	}

}
