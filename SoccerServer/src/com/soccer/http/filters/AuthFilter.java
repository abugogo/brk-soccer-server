package com.soccer.http.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class AuthFilter implements Filter {
	private FilterConfig filterConfig = null;
	final static public String authCookieName = "socookauth";

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void destroy() {
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		if (filterConfig == null)
			return;
		HttpServletRequest hsr = (HttpServletRequest) request;
		boolean valid = false;
		Cookie cs[] = hsr.getCookies();
		if (cs != null) {
			for (int i = 0; i < cs.length; i++) {
				String n = cs[i].getName();
				if (n != null && n.equals(authCookieName)) {
					if (true) { // check valid cookie
						valid = true;
					}
				}

			}
		}

		if(valid)
			chain.doFilter(request, response);
		else {
			HttpServletResponse res = (HttpServletResponse)response;
			res.setStatus(401);
			res.sendError(401, "Missing essential header");
		}
	}

	public static boolean HasCookie(HttpServletRequest request, String cookie) {
		boolean has = false;
		if (request != null) {
			Cookie cs[] = request.getCookies();
			if (cs != null) {
				for (int i = 0; i < cs.length; i++) {
					String n = cs[i].getName();

					if (n != null && n.equals(cookie)) {
						has = true;
						break;
					}

				}
			}
		}

		return has;
	}
}
