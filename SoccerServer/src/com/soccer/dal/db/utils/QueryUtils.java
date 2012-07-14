package com.soccer.dal.db.utils;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;


public class QueryUtils {

	private QueryUtils() {}
	
//	public static List<HashMap<String, Object>> query(DataSource ds, String query) {
//		List<HashMap<String, Object>> result = null;
//	    try {
//	    	QueryRunner qrun = new QueryRunner(ds);
//	        result = (List) qrun.query(ds.getConnection(), query, new MapListHandler());
//	    } catch (Exception ex) {
//	        ex.printStackTrace();
//	    }
//	    return result;
//	}
//
	public static int update(Connection con, String query) {
		int result = 0;
	    try {
	        QueryRunner qrun = new QueryRunner();
	        result =  qrun.update(con, query);
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	    return result;
	}
}
