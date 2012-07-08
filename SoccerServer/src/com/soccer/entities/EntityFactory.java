package com.soccer.entities;

import org.json.JSONException;
import org.json.JSONObject;

import com.soccer.lib.SoccerException;

public class EntityFactory {
	public static Player createPlayer(JSONObject json) throws SoccerException {
		try {
			Player p = new Player();
			p.setId(json.getString("id"));
			p.setFirstName(json.getString("firstName"));
			if (json.has("lastName")) {
				p.setLastName(json.getString("lastName"));
			}
			if (json.has("occupation")) {
				p.setOccupation(json.getString("occupation"));
			}
			if (json.has("facebookPage")) {
				p.setFacebookPage(json.getString("facebookPage"));
			}
			return p;
		} catch (JSONException e) {
			throw new SoccerException("Missing mandatory field", e);
		}
	}
}
