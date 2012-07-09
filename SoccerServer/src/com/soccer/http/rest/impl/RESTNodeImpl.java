package com.soccer.http.rest.impl;

import java.util.HashMap;
import java.util.Map;

import com.soccer.http.HttpMethod;
import com.soccer.http.rest.RESTNode;

public class RESTNodeImpl<T> implements RESTNode<T> {
	private Map<String, RESTNodeImpl<T>> subNodes = new HashMap<>();
	private Map<HttpMethod, T> actions = new HashMap<>();
	
	/* (non-Javadoc)
	 * @see com.soccer.http.rest.RESTNode#getSubNode(java.lang.String)
	 */
	@Override
	public RESTNode<T> getSubNode(String loc) {
		if (this.subNodes.containsKey(loc)) {
			return this.subNodes.get(loc);
		} else {
			return null;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.soccer.http.rest.RESTNode#addSubNode(java.lang.String)
	 */
	@Override
	public RESTNode<T> addSubNode(String loc) { //TODO: Check if possible
		RESTNodeImpl<T> node = new RESTNodeImpl<T>();
		this.subNodes.put(loc, node);
		return node;
	}
	
	/* (non-Javadoc)
	 * @see com.soccer.http.rest.RESTNode#getAction(com.soccer.http.HttpMethod)
	 */
	@Override
	public T getAction(HttpMethod method) {
		return this.actions.get(method);
	}
	
	/* (non-Javadoc)
	 * @see com.soccer.http.rest.RESTNode#setAction(com.soccer.http.rest.RESTAction, com.soccer.http.HttpMethod)
	 */
	@Override
	public void setAction(T action, HttpMethod method) {
		this.actions.put(method, action);
	}
}
