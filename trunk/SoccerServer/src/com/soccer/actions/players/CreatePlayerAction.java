package com.soccer.actions.players;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.entities.EntityManager;
import com.soccer.entities.IDAOPlayer;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.services.SoccerService;

public class CreatePlayerAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req,
			HttpServletResponse resp) {
		IDAOPlayer p = EntityManager.readPlayer(req.getParameter("JSON"));
		SoccerService.getInstance().createPlayer(p);
	}
}
