package com.soccer.actions.season;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.entities.EntityManager;
import com.soccer.entities.IDAOSeason;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.lib.SoccerException;
import com.soccer.services.SeasonsService;

public class GetSeasonsAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<IDAOSeason> seasons = SeasonsService.getInstance().getSeasons();
			EntityManager.writeSeasons(seasons, resp.getOutputStream());
			resp.setContentType("application/json");
		} catch (SoccerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
