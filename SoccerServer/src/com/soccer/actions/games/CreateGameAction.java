package com.soccer.actions.games;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.soccer.entities.IDAOGame;
import com.soccer.entities.impl.DAOGame;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.services.SoccerService;

public class CreateGameAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req, HttpServletResponse resp) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			IDAOGame game = mapper.readValue(req.getInputStream(), DAOGame.class);
			SoccerService.getInstance().createGame(game);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
