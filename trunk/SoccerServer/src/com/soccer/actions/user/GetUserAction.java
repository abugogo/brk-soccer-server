package com.soccer.actions.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.entities.EntityManager;
import com.soccer.entities.IDAOUser;
import com.soccer.http.ContentType;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.lib.SoccerException;
import com.soccer.services.SystemService;

public class GetUserAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req, HttpServletResponse resp) {
		try {
			IDAOUser user = EntityManager.readUser(req.getParameter("JSON"));
			if(user != null && !"".equals(user.getId())) {
				IDAOUser u = SystemService.getInstance().getUser(user.getId().toString(), user.getPassword());
				EntityManager.writeUserToStream(u, resp.getOutputStream());
				resp.setContentType(ContentType.JSON.getType());
			}
			
		} catch (SoccerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
