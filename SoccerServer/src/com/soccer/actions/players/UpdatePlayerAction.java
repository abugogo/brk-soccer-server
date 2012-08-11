package com.soccer.actions.players;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.entities.EntityManager;
import com.soccer.entities.IDAOPlayer;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.lib.SoccerException;
import com.soccer.services.SoccerService;

public class UpdatePlayerAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req, HttpServletResponse resp) {
		try {
			IDAOPlayer p = EntityManager.readPlayer(req.getInputStream());
			if (!p.getId().equals(path.getPathArray()[1])) {
				throw new SoccerException("Bad input - player id in url and player id in body are different");
			}
			SoccerService.getInstance().updatePlayer(p);
		} catch (SoccerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
