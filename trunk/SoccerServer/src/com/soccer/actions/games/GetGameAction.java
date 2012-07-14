package com.soccer.actions.games;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.entities.IDAOGame;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.services.SoccerService;

import flexjson.JSONSerializer;

public class GetGameAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req,
			HttpServletResponse resp) {
		String ser = "";
		String[] pathInfo = path.getPathArray();
		IDAOGame g = null;
		try {
			if (pathInfo != null && pathInfo.length == 2) {
				g = SoccerService.getInstance().getGame(pathInfo[1]);
			}

			JSONSerializer serializer = new JSONSerializer();
			ser = serializer.serialize(g);

			resp.getOutputStream().write(ser.getBytes("UTF-8"));
			resp.setContentType("application/json");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
