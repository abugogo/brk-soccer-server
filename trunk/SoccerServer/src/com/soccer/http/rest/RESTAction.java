package com.soccer.http.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author udi
 *
 */
public interface RESTAction {
	
	/**
	 * This method invokes the action this REST call should do
	 * @param path
	 * @param req
	 * @param resp
	 */
	void invoke(RESTPath path, HttpServletRequest req, HttpServletResponse resp);
}
