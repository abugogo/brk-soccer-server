package com.soccer.http.oauth;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openid4java.discovery.Identifier;

//@WebServlet("/openid")
public class OpenIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("*********************************************************");
		System.out.println("Parameters: ");
		System.out.println("*********************************************************");
		for (Entry<String, String[]> entry : req.getParameterMap().entrySet()) {
			System.out.println("Entry:\n\tKey  : " + entry.getKey() + " \n\tValue: " + entry.getValue()[0]);
		}

	
		System.out.println("*********************************************************");
		System.out.println("Headers: ");
		System.out.println("*********************************************************");
		Enumeration<String> headerNames = req.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String header = headerNames.nextElement();
			System.out.println("\tHeader: " + header);
			System.out.println("\tValues: ");
			Enumeration<String> values = req.getHeaders(header);
			while (values.hasMoreElements()) {
				System.out.println("\t\t" + values.nextElement());
			}
		}

		System.out.println("*********************************************************");
		System.out.println("Session SHIT: ");
		System.out.println("*********************************************************");
		Enumeration<String> attributeNames = req.getSession().getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String attribute = attributeNames.nextElement();
			System.out.println("\tAttribute: " + attribute);
			Object attribute2 = req.getSession().getAttribute(attribute);
			System.out.println("\tValue    : " + attribute2);
		}
		
		Object obj = req.getSession().getAttribute("openid.consumer");
		if (obj == null) {
			throw new IllegalAccessError();
		}
		SoccerOpenIDConsumer openIDConsumer = (SoccerOpenIDConsumer) obj;
		Identifier verifyResponse = openIDConsumer.verifyResponse(req);
		System.out.println(verifyResponse.getIdentifier());
	}
}
