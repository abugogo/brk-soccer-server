package com.soccer.http.rest.impl;

import java.util.Arrays;

import com.soccer.http.HttpMethod;
import com.soccer.http.context.RequestContext;
import com.soccer.http.rest.RESTPath;

public class RESTPathCtxtImpl implements RESTPath {
	private String pathStr;
	private String[] pathArray;
	private String context;
	private HttpMethod method;
	
	public RESTPathCtxtImpl(String path, HttpMethod method) {
		this.method = method;
		
		if (path == null) {
			this.pathArray = new String[0];
		} else {
			if (path.startsWith("/")) { // Removing the first slash (/) if there is one.
				path = path.substring(1);
			}
			String[] sarray = path.split("/");
			if(sarray.length > 1) {
				context = sarray[0];
				RequestContext.setAttribute(RequestContext.REQ_CONTEXT, context);
				this.pathArray = Arrays.copyOfRange(sarray, 1, sarray.length);//path.split("/");
			}
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

	public String getContext() {
		return this.context;
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
