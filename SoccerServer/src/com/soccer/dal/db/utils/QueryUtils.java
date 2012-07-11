package com.soccer.dal.db.utils;

import java.util.HashMap;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import java.sql.Connection;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;


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
