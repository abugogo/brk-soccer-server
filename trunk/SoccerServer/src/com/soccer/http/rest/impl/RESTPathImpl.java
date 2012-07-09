package com.soccer.http.rest.impl;

import com.soccer.http.HttpMethod;
import com.soccer.http.rest.RESTPath;

public class RESTPathImpl implements RESTPath {
	private String pathStr;
	private String[] pathArray;
	private HttpMethod method;
	
	public RESTPathImpl(String path, HttpMethod method) {
		this.method = method;
		
		if (path == null) {
			this.pathArray = new String[0];
		} else {
			if (path.startsWith("/")) { // Removing the first slash (/) if there is one.
				path = path.substring(1);
			}
			this.pathArray = path.split("/");
		}

		this.pathStr = path;
	}

	/* (non-Javadoc)
	 * @see com.soccer.http.rest.RESTPath#getPathStr()
	 */
	@Override
	public String getPathStr() {
		return this.pathStr;
	}

	/* (non-Javadoc)
	 * @see com.soccer.http.rest.RESTPath#getPathArray()
	 */
	@Override
	public String[] getPathArray() {
		return pathArray;
	}

	/* (non-Javadoc)
	 * @see com.soccer.http.rest.RESTPath#getMethod()
	 */
	@Override
	public HttpMethod getMethod() {
		return method;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return this.pathStr + ":" + this.method.toString();
	}
}
