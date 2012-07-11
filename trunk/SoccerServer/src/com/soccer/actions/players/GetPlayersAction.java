package com.soccer.actions.players;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.db.entities.handlers.PlayersActionHandler;
import com.soccer.entities.IDAOPlayer;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;

import flexjson.JSONSerializer;

public class GetPlayersAction implements RESTAction {
	
	@Override
	public void invoke(RESTPath path, HttpServletRequest req,
			HttpServletResponse resp) {
		String ser = "";
		List<IDAOPlayer> l = null;
		try {
			l = PlayersActionHandler.getAllPlayers();

			JSONSerializer serializer = new JSONSerializer();
			ser = serializer.serialize(l);

			resp.getOutputStream().write(ser.getBytes("UTF-8"));
			resp.setContentType("application/json");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
