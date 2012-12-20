package com.soccer.actions.season;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.entities.EntityManager;
import com.soccer.entities.IDAOSeason;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.services.SeasonsService;

public class CreateSeasonAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req,
			HttpServletResponse resp) {
		IDAOSeason season = EntityManager.readSeason(req.getParameter("JSON"));
		SeasonsService.getInstance().createSeason(season);
	}

}
