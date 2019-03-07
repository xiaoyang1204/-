package com.juyi.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class AjaxFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpServletResponse=(HttpServletResponse) response;  
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");  
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Authentication"); 
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(request, httpServletResponse);  
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
