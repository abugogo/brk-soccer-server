package com.soccer.http.rest.impl;

import com.soccer.http.rest.RESTNode;
import com.soccer.http.rest.RESTPath;
import com.soccer.http.rest.RESTRegistry;


public class RESTRegistryMapImpl<T> implements RESTRegistry<T> {
	RESTNode<T> root;
	
	public RESTRegistryMapImpl() {
		this.root = new RESTNodeImpl<T>();
	}
	
	/* (non-Javadoc)
	 * @see com.soccer.http.rest.RESTRegistry#registerPath(com.soccer.http.rest.RESTPath, com.soccer.http.rest.RESTAction)
	 */
	@Override
	public void registerAction(RESTPath path, T action) {
		RESTNode<T> currNode = this.root;
		String[] pathArray = path.getPathArray();

		for (String s : pathArray) {
			RESTNode<T> subNode = currNode.getSubNode(s);
			if (subNode == null) {
				subNode = currNode.addSubNode(s);
			}
			currNode = subNode;
		}
		
		currNode.setAction(action, path.getMethod());
	}
	
	/* (non-Javadoc)
	 * @see com.soccer.http.rest.RESTRegistry#getAction(com.soccer.http.rest.RESTPath)
	 */
	@Override
	public T getAction(RESTPath path) {
		RESTNode<T> currNode = this.root;
		String[] pathArray = path.getPathArray();
		for (String s : pathArray) {
			RESTNode<T> subNode = currNode.getSubNode(s);
			if (subNode == null) {
				subNode = currNode.getSubNode("*");
				if (subNode == null) {
					return null;
				}
			}
			currNode = subNode;
		}
		
		return currNode.getAction(path.getMethod());
	}
}
