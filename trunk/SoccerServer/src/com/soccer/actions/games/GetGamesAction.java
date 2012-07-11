package com.soccer.actions.games;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.db.entities.handlers.GamesActionHandler;
import com.soccer.entities.IDAOGame;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;

import flexjson.JSONSerializer;

public class GetGamesAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req,
			HttpServletResponse resp) {
		String ser = "";
		List<IDAOGame> l = null;
		try {
			l = GamesActionHandler.getAllGames();

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
