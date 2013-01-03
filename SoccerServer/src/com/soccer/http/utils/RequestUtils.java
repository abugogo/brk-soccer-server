package com.soccer.http.utils;

import java.io.BufferedReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {
	public static String ReadJSON(HttpServletRequest req) {
		StringBuffer jb = new StringBuffer();
		String ret = "";
		String line = null;
		try {
			BufferedReader reader = req.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		try {
			String reqBody = URLDecoder.decode(jb.toString(), "UTF-8");
			String entity[] = reqBody.split("=");
			if(reqBody != null && entity.length == 2)
				ret = entity[1];
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
}
