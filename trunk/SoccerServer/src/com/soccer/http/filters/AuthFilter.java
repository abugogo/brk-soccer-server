package com.soccer.http.filters;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soccer.http.context.RequestContext;
import com.soccer.http.cookie.CookieGen;
import com.soccer.services.SystemService;

public final class AuthFilter implements Filter {
	private static final Logger LOGGER = Logger.getLogger(AuthFilter.class.getCanonicalName());
	private FilterConfig filterConfig = null;
	final static public String authCookieName = "socookauth";

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void destroy() {
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) {

		if (filterConfig == null)
			return;
		HttpServletRequest hsr = (HttpServletRequest) request;
		boolean valid = false;
		RequestContext.initialize();
		
		Cookie cs[] = hsr.getCookies();
		if (cs != null) {
			for (int i = 0; i < cs.length; i++) {
				String n = cs[i].getName();
				if (n != null && n.equals(authCookieName)) {
					valid = extractCookieInfo(cs[i].getValue());
					break;
				}

			}
		}
		HttpServletResponse res = (HttpServletResponse) response;
		
		try {
			if (valid) {
				chain.doFilter(request, response);
			}
			else {
				res.setStatus(401);
				res.sendError(401, "Missing essential header");
			}
		} catch (IOException e) {
			res.setStatus(500);
			e.printStackTrace();
		} catch (ServletException e) {
			res.setStatus(500);
			e.printStackTrace();
		} finally {
			RequestContext.cleanup();
		}
	}

	private boolean extractCookieInfo(String c) {
		boolean valid = false;
		String[] parts = c.split("\\".concat(CookieGen.DELIMITER));
		if (parts != null && parts.length == 3) {
			String genCookie = CookieGen.generateCookieForUser(parts[0],
					parts[1],
					SystemService.getInstance().getUserPassword(parts[0]),
					SystemService.getInstance().getUserSalt(parts[0]));
			valid = genCookie.equals(c);
			if(valid) {
				LOGGER.info("logged in user: ".concat(parts[0]));
				RequestContext.setAttribute(RequestContext.LOGGED_IN_USER, parts[0]);
			}
			else {
				LOGGER.info("authentication failed for logged in user: ".concat(parts[0]));
			}
		}
		return valid;
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
