package com.soccer.actions.players;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.soccer.entities.IDAOPlayer;
import com.soccer.entities.impl.DAOPlayer;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.lib.SoccerException;
import com.soccer.services.SoccerService;

public class UpdatePlayerAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req, HttpServletResponse resp) {
		try {
			Gson gson = new Gson();
			IDAOPlayer p = gson.fromJson(req.getParameter("JSON"), DAOPlayer.class);
			//IDAOPlayer p = EntityManager.readPlayer(req.getInputStream());
			
			//IDAOPlayer p = EntityManager.readPlayer(req.getInputStream());
			if (!p.getId().equals(path.getPathArray()[1])) {
				throw new SoccerException("Bad input - player id in url and player id in body are different");
			}
			IDAOPlayer res = SoccerService.getInstance().updatePlayer(p);
			resp.getOutputStream().write("{result=success}".getBytes());
		} catch (SoccerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
