package com.soccer.http;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.soccer.http.rest.RESTAction;
import com.soccer.http.rest.RESTPath;
import com.soccer.http.rest.RESTRegistry;
import com.soccer.http.rest.impl.RESTPathImpl;
import com.soccer.http.rest.impl.RESTRegistryMapImpl;
import com.soccer.lib.XMLUtils;

/**
 * Servlet implementation class RESTServlet.
 * This should be the main entry point for any server communication
 * 
 * @author Udi
 */
@WebServlet("/rest/*")
public class RESTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(RESTServlet.class.getCanonicalName());
	
	private RESTRegistry<RESTAction> registry;
	@Override
	public void init(ServletConfig cfg) throws ServletException {
		super.init(cfg);
		this.registry = new RESTRegistryMapImpl<RESTAction>();
		//this.registry.registerAction(new RESTPathImpl("players/*", HttpMethod.GET), new GetPlayerAction());
		initServices(cfg);
	}
	
	private void initServices(ServletConfig cfg) {
		String path = cfg.getServletContext().getRealPath("/WEB-INF");
		Document doc = XMLUtils.parseXmlFile(path + "/rest_services.xml");
		Element docEle = doc.getDocumentElement();
		NodeList nl = docEle.getElementsByTagName("entity");
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {
				Element el = (Element) nl.item(i);
				// get the Employee object
				String URI = XMLUtils.getTextValue(el,"uri");
				String Method = XMLUtils.getTextValue(el,"method");
				String Cl = XMLUtils.getTextValue(el,"class");
				// add it to list
				try {
					// adding all methods to same handler which can then decide what to do per method
					this.registry.registerAction(new RESTPathImpl(URI, HttpMethod.valueOf(Method)), (RESTAction)Class.forName(Cl).newInstance());
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(HttpMethod.GET, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(HttpMethod.POST, request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(HttpMethod.PUT, request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(HttpMethod.DELETE, request, response);
	}
	
	private void handleRequest(HttpMethod method, HttpServletRequest request, HttpServletResponse response) {
		try {
			RESTPath path = new RESTPathImpl(request.getPathInfo(), method);
			LOGGER.info("REST path is " + path);
			RESTAction action = this.registry.getAction(path);
			
			if (action != null) {
				LOGGER.info("Invoking action " + action.getClass().getCanonicalName());
				action.invoke(path, request, response);
			} else {
				response.getOutputStream().write(("{\"status\": \"error\", \"error\": {\"message\": " + JSONObject.quote("Path " + path.toString() + " is not registered") + "}}").getBytes("UTF-8"));
				response.setContentType("application/json");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
