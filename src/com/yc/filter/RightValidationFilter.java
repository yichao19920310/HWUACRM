package com.yc.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.bean.Right;

public class RightValidationFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		@SuppressWarnings("unchecked")
		List<Right> rights = (List<Right>) req.getSession().getAttribute("rights");
		String requestURI = req.getRequestURI();
		int lastIndexOf = requestURI.lastIndexOf("/");		
		String targetLocation = requestURI.substring(lastIndexOf+1);
		for (Right right : rights) {
			System.out.println(right);
			if (right.getUrl().equals(targetLocation)) {
				arg2.doFilter(req,resp);
				return;
			}
		}
		resp.sendRedirect("error.jsp");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
