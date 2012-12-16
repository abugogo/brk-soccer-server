package com.soccer.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.entities.EntityManager;
import com.soccer.entities.impl.DAOUser;
import com.soccer.http.cookie.CookieGen;
import com.soccer.http.filters.AuthFilter;
import com.soccer.lib.SoccerException;
import com.soccer.services.SystemService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static private String loginHeaderName = "socooklogin";
	final static private String juser = "j_user";
	final static private String jpassword = "j_password";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (!basicAuthLogin(req, resp)) {
			Writer writer = resp.getWriter();
			writer.write("Error");
			writer.flush();
			writer.close();
		}
	}

	private boolean basicAuthLogin(HttpServletRequest request,
			HttpServletResponse response) {
		String userID = null;
		String password = null;
		boolean valid = false;

		String authHeader = request.getHeader(loginHeaderName);
		boolean cont = false;

		if (request.getParameter("u") != null) {
			userID = request.getParameter("u");
			password = request.getParameter("p");
			cont = true;
		}

		if (cont || (authHeader != null && !authHeader.equals(""))) {
			if (request.getContentLength() > 0) {
				String line;

				try {
					BufferedReader rd = new BufferedReader(request.getReader());
					while ((line = rd.readLine()) != null) {
						int index = line.indexOf("=");
						if (index != -1) {
							String name = line.substring(0, index);
							String value = line.substring(index + 1);
							if (name != null) {
								if (name.equals(juser)) {
									userID = value;
								} else if (name.equals(jpassword)) {
									password = value;
								}
							}
						}
					}
					rd.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			DAOUser user = (DAOUser) SystemService.getInstance().getUser(
					userID, password);
			if (user != null && user.getId().signum() == 1) {
				// set cookie
				try {
					String genCookie = CookieGen
							.generateCookieForUser(user.getId(), "", password, SystemService.getInstance()
									.getUserSalt(user.getId().toString()));
					Cookie cookie = new Cookie(AuthFilter.authCookieName,
							genCookie);
					response.addCookie(cookie);

					EntityManager.writeUserToStream(user,
							response.getOutputStream());
					response.setContentType("application/json");
					response.setStatus(200);
				} catch (SoccerException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				valid = true;
			}
		}

		if (!valid) {
			response.setStatus(401);
		}

		return valid;
	}
}
