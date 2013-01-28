package com.soccer.http.context;

import java.util.HashMap;
import java.util.Map;

public class RequestContext {
	public final static String REQ_CONTEXT_SCHEMA = "requestContext";
	public final static String LOGGED_IN_USER = "loggedInUser";
	public final static String REQ_CONTEXT_ACCOUNT = "requestAccount";
	
	
    private static ThreadLocal<Map<Object, Object>> attributes = new ThreadLocal<Map<Object, Object>>();
    public static void initialize() {
        attributes.set(new HashMap<Object, Object>());
    }
    public static void cleanup() {
        attributes.set(null);
    }
    
    public static Object getAttribute(Object key) {
        return attributes.get().get(key);
    }
    public static void setAttribute(Object key, Object value) {
        attributes.get().put(key, value);
    }
}