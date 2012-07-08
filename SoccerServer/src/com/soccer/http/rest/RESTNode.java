package com.soccer.http.rest;

import com.soccer.http.HttpMethod;

/**
 * This class represents a single node in the {@link RESTRegistry}.
 * 
 * @author Udi
 * 
 * @param <T>
 *            is the class of the "action" that will be stored in this node
 */
public interface RESTNode<T> {

	/**
	 * This method returns a sub-node corresponds to the location
	 * <code>loc</code>
	 * 
	 * @param loc
	 *            the location to retrieve the sub-node from
	 * @return the sub-node in the requested location
	 */
	RESTNode<T> getSubNode(String loc);

	/**
	 * Adds a new sub-node in the specified location. If a sub-node existed
	 * under the location then override it.
	 * 
	 * @param loc
	 *            the location to add the new sub-node
	 * @return the newly created sub-node
	 */
	RESTNode<T> addSubNode(String loc);

	/**
	 * This method fetches the action stored in this node under a specified
	 * method.
	 * 
	 * @param method
	 *            the method under which the action defined
	 * @return the action
	 */
	T getAction(HttpMethod method);

	/**
	 * This method registers a new action under the specified method. If an
	 * action was already registered under the method then it will override it.
	 * 
	 * @param action
	 *            the action to register
	 * @param method
	 *            the method to register the action to
	 */
	void setAction(T action, HttpMethod method);

}