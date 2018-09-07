package io.github.julianjupiter.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController extends HttpServlet {

	private static final long serialVersionUID = 632349127293785744L;
	private static final String VIEW_PREFIX = "/WEB-INF/templates/";
	private static final String VIEW_SUFFIX = ".jsp";
	
	protected String getAction(HttpServletRequest request) {
		String action = request.getParameter("action");
		
		return (action == null) || action.isEmpty() ? "" : action;
	}

	protected void render(HttpServletRequest request, HttpServletResponse response, String template) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(VIEW_PREFIX + template + VIEW_SUFFIX).forward(request, response);
    }

	public void redirect(HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(path);
    }
	
}
