package com.soccer.actions.players;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.db.entities.handlers.PlayersActionHandler;
import com.soccer.entities.IDAOPlayer;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;

import flexjson.JSONSerializer;

public class GetPlayerAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req,
			HttpServletResponse resp) {
		String ser = "";
		IDAOPlayer p = null;
		String[] pathInfo = path.getPathArray();
		try {
			if (pathInfo != null && pathInfo.length == 2) {
				p = PlayersActionHandler.getPlayer(pathInfo[1]);
			}

			JSONSerializer serializer = new JSONSerializer();
			ser = serializer.serialize(p);

			resp.getOutputStream().write(ser.getBytes("UTF-8"));
			resp.setContentType("application/json");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
