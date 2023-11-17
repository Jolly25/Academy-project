package com.corso.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		//prevent browser to load page from cache when click back arrow
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		res.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		res.setDateHeader("Expires", 0); // Proxies.

		HttpSession s = req.getSession();
		
		s.setMaxInactiveInterval(60*10); //invalidate session after 10 minutes

		if(s.getAttribute("user") == null) {
			res.sendRedirect(req.getContextPath() + "/not_logged");
			return;
		}
		chain.doFilter(request, response);

	}

}
