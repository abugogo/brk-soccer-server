package com.soccer.actions.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;

import com.soccer.entities.EntityManager;
import com.soccer.entities.IDAOUser;
import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.http.utils.RequestUtils;
import com.soccer.services.SystemService;

public class CreateUserAction implements RESTAction {

	@Override
	public void invoke(RESTPath path, HttpServletRequest req,
			HttpServletResponse resp) {
		int res = 0;
		String json = RequestUtils.ReadJSON(req);
		try {
			if (json != null && !json.isEmpty()) {
				IDAOUser user = EntityManager.readUser(json);
				if (user != null && !"".equals(user.getId())) {
					res = SystemService.getInstance().createUser(user, "");
				}
			}
			if (res > 0) {
				resp.getOutputStream().write("{result=success}".getBytes());
				resp.setStatus(HttpStatus.SC_OK);
			} else {
				resp.getOutputStream().write("{result=failure}".getBytes());
				resp.setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
