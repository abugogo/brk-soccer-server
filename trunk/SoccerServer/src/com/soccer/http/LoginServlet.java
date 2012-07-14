package com.soccer.http;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openid4java.consumer.ConsumerException;

import com.soccer.http.oauth.SoccerOpenIDConsumer;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			
			SoccerOpenIDConsumer openIDConsumer = new SoccerOpenIDConsumer();
			req.getSession().setAttribute("openid.consumer", openIDConsumer);
			openIDConsumer.authRequest("https://www.google.com/accounts/o8/id", req, resp, getServletContext());
		} catch (ConsumerException e) {
			e.printStackTrace();
		}
	}
}
