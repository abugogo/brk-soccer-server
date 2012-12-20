package com.soccer.actions.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.entities.EntityManager;
import com.soccer.entities.IDAOUser;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.services.SystemService;

public class CreateUserAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req,
			HttpServletResponse resp) {
		IDAOUser user = EntityManager.readUser(req.getParameter("JSON"));
		if (user != null && user.getId().signum() == 1) {
			SystemService.getInstance().createUser(user, "");
		}
	}

}
