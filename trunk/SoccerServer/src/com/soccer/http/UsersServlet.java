package com.soccer.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.soccer.entities.IDAOUser;
import com.soccer.entities.impl.DAOUser;
import com.soccer.services.SystemService;

/**
 * Servlet implementation class RESTServlet. This should be the main entry point
 * for any server communication
 * 
 * @author Udi
 */
//@WebServlet("/users/*")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(UsersServlet.class
			.getCanonicalName());

	@Override
	public void init(ServletConfig cfg) throws ServletException {
		super.init(cfg);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("u");
		String pwd = request.getParameter("p");
		IDAOUser user = SystemService.getInstance().getUser(uid, pwd);
		Gson gson = new Gson();
		response.getOutputStream().write(gson.toJson(user).getBytes());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		StringBuffer sb = new StringBuffer();
		BufferedReader bufferedReader = null;

		try {
			bufferedReader = request.getReader();
			char[] charBuffer = new char[128];
			int bytesRead;
			while ((bytesRead = bufferedReader.read(charBuffer)) != -1) {
				sb.append(charBuffer, 0, bytesRead);
			}

		} catch (IOException ex) {
			throw ex;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}

		String uasstr = sb.toString();
		//IDAOUser u = gson.fromJson(request.getParameter("JSON"), DAOUser.class);
		IDAOUser u = gson.fromJson(uasstr, DAOUser.class);
		if (SystemService.getInstance().createUser(u, "") > 0)
			response.getOutputStream().write(("Success").getBytes());
		else
			response.getOutputStream().write(("Failure. Examine server log").getBytes());
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		handleRequest(HttpMethod.PUT, request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		handleRequest(HttpMethod.DELETE, request, response);
	}

	private void handleRequest(HttpMethod method, HttpServletRequest request,
			HttpServletResponse response) {
	}

}
