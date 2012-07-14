package com.soccer.actions.players;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.entities.IDAOPlayer;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.services.SoccerService;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class PutPlayersAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req,
			HttpServletResponse resp) {
		String ser = "";
		List<IDAOPlayer> l = null;
		try {
			StringBuffer jb = new StringBuffer();
			String line = null;
			BufferedReader reader = req.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);

			IDAOPlayer p = new JSONDeserializer<IDAOPlayer>().deserialize(jb.toString());
			if(p!=null) {
				SoccerService.getInstance().createPlayer(p);
			}
			
			
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
