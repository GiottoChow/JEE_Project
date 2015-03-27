package com.tas.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class EncodingFilter implements Filter {

	@Override
	public void destroy() {
		this.config = null;
		this.encoding = null;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filterChain) throws IOException, ServletException {

		String encoding = selectEncoding(req);
		if (encoding != null) {
			req.setCharacterEncoding(encoding);
		}
		filterChain.doFilter(req, resp);
	}

	protected String selectEncoding(ServletRequest req) {
		return this.encoding;
	}

	protected FilterConfig config;
	protected String encoding;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		this.encoding = config.getInitParameter("encoding");
	}

}