package com.soccer.actions.season;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.entities.EntityManager;
import com.soccer.entities.IDAOSeason;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.lib.SoccerException;
import com.soccer.services.SeasonsService;

public class GetSeasonAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req, HttpServletResponse resp) {
		try {
			String seasonIdStr = path.getPathArray()[1];
			int seasonId = Integer.parseInt(seasonIdStr);
			IDAOSeason season = SeasonsService.getInstance().getSeason(seasonId);
			EntityManager.writeSeason(season, resp.getOutputStream());
			resp.setContentType("application/json");
		} catch (SoccerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setContentType("application/json");
	}

}
