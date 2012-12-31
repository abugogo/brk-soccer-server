package com.soccer.actions.games;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;

import com.soccer.entities.EntityManager;
import com.soccer.entities.IDAOGame;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.services.SoccerService;

public class CreateGameAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req,
			HttpServletResponse resp) {
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = req.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) { /* report an error */
		}

		//IDAOGame game = EntityManager.readGame(req.getParameter("JSON"));
		IDAOGame game = EntityManager.readGame(jb.toString());
		try {
			if (SoccerService.getInstance().createGame(game) > 0) {
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
