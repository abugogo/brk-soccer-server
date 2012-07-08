package com.soccer.http.rest;

/**
 * This interface describes a REST registry class that REST servlets can use to
 * implement and support REST
 * 
 * @author Udi
 * 
 * @param <T>
 *            is the class of the "action" that will be stored in the registry
 */
public interface RESTRegistry<T> {

	/**
	 * This method registers an action to invoked in a specific path
	 * 
	 * @param path
	 *            the path to register the action. The path may contain nodes
	 *            that are a wildcard, meaning a path <code>/players/*</code>
	 *            will match calls like: <code>.../rest/players/i041539</code>
	 *            or <code>.../rest/players/042050331</code>
	 * @param action
	 *            the action to invoke
	 */
	void registerAction(RESTPath path, T action);

	/**
	 * This method fetches an action registered on a specific path. If no action
	 * is registered then null is returned
	 * 
	 * @param path
	 *            the path to the action
	 * @return The action corresponds to the supplied path
	 */
	T getAction(RESTPath path);

}