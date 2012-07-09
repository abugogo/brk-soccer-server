package com.soccer.http.rest;

import com.soccer.http.HttpMethod;

/**
 * This class represents a REST call
 * @author Udi
 *
 */
public interface RESTPath {

	/**
	 * This method return the path of the REST call
	 * @return an array representing the path nodes
	 */
	String[] getPathArray();

	/**
	 * This method return the path of the REST call
	 * @return a {@link String} of the path
	 */
	String getPathStr();
	
	/**
	 * This method return the HTTP method of the REST call
	 * @return the method of the HTTP call
	 */
	HttpMethod getMethod();

}