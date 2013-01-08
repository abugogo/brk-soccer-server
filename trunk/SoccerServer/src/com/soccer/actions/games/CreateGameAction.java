package com.soccer.actions.games;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;

import com.soccer.entities.EntityManager;
import com.soccer.entities.IDAOGame;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.http.utils.RequestUtils;
import com.soccer.services.SoccerService;

public class CreateGameAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req,
			HttpServletResponse resp) {

		String json = RequestUtils.ReadJSON(req);
		if (json != null && !json.isEmpty()) {
			IDAOGame igame = EntityManager.readGame(json);
			try {
				if (igame != null
						&& SoccerService.getInstance().createGame(igame) > 0) {
					resp.getOutputStream().write("{result=success}".getBytes());
					resp.setStatus(HttpStatus.SC_OK);
				} else {
					resp.getOutputStream().write("{result=failure}".getBytes());
					resp.setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
