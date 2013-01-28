package com.soccer.http.rest.impl;

import java.util.Arrays;

import com.soccer.http.HttpMethod;
import com.soccer.http.context.RequestContext;
import com.soccer.http.rest.RESTPath;
import com.soccer.services.SystemService;

public class RESTPathCtxtImpl implements RESTPath {
	private String pathStr;
	private String[] pathArray;
	private String account, context_schema;
	private HttpMethod method;

	public RESTPathCtxtImpl(String path, HttpMethod method) throws Exception {
		this.method = method;

		if (path == null) {
			this.pathArray = new String[0];
		} else {
			if (path.startsWith("/")) { // Removing the first slash (/) if there
										// is one.
				path = path.substring(1);
			}
			String[] sarray = path.split("/");
			if (sarray.length > 1) {
				account = sarray[0];
				String uid = (String) RequestContext
						.getAttribute(RequestContext.LOGGED_IN_USER);
				context_schema = SystemService.getInstance().getSchemaForAccount(uid,
						account);
				if (context_schema != null && !context_schema.isEmpty()) {
					RequestContext.setAttribute(RequestContext.REQ_CONTEXT_SCHEMA,
							context_schema);
					RequestContext.setAttribute(RequestContext.REQ_CONTEXT_ACCOUNT,
							account);
				}
				else
					throw new Exception(
							"Unauthorised user. Does not belong to account");
				this.pathArray = Arrays.copyOfRange(sarray, 1, sarray.length);// path.split("/");
			}
		}

		this.pathStr = path;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.soccer.http.rest.RESTPath#getPathStr()
	 */
	@Override
	public String getPathStr() {
		return this.pathStr;
	}

	public String getContext() {
		return this.account;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.soccer.http.rest.RESTPath#getPathArray()
	 */
	@Override
	public String[] getPathArray() {
		return pathArray;
	}

	/*
	 * (non-Javadoc)
	 * 
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
