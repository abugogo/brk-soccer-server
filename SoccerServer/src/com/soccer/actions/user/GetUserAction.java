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
			IDAOUser user = EntityManager.readUser(req.getInputStream());
			if(user != null && user.getId().signum() == 1) {
				IDAOUser u = SystemService.getInstance().getUser(user.getId().toString(), user.getPassword());
				EntityManager.writeUserToStream(u, resp.getOutputStream());
				resp.setContentType(ContentType.JSON.getType());
			}
			
		} catch (SoccerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
