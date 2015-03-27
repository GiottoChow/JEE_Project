package com.tas.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tas.model.User;

@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		servletContext = null;
		servletContext.log("Filter destory");
	}

	@Inject
	EntityManager em;

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) req;
		HttpServletResponse httpResp = (HttpServletResponse) resp;
		HttpSession session = httpReq.getSession(false);

		if (session != null) {
			User user = (User) session.getAttribute("user");
			if (user != null) {
				if (session.getId().equals(user.getLastSessionId())) {

					httpResp.setHeader("Cache-Control", "private");
					httpResp.setDateHeader("Expires", 0);

					filterChain.doFilter(req, resp);
					return;
				}
			}
		}

		if (httpReq.getRequestURI().equals("/login.jsf")) {
			filterChain.doFilter(req, resp);
		} else {
			httpResp.sendRedirect("/login.jsf");
		}
	}

	private ServletContext servletContext;

	@Override
	public void init(FilterConfig config) throws ServletException {
		servletContext = config.getServletContext();
		servletContext.log("Login Filter initialized");
	}

}