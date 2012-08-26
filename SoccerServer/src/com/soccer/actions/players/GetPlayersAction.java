package com.soccer.actions.players;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.entities.EntityManager;
import com.soccer.entities.IDAOPlayer;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.lib.SoccerException;
import com.soccer.services.SoccerService;

public class GetPlayersAction implements RESTAction {
	
	@Override
	public void invoke(RESTPath path, HttpServletRequest req, HttpServletResponse resp) {
		List<IDAOPlayer> activePlayers = SoccerService.getInstance().getActivePlayers();
		try {
			EntityManager.writePlayersToStream(activePlayers, resp.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SoccerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
