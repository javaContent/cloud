package com.test.system.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;

@WebFilter(filterName = "urlFilter", urlPatterns = "/api/system/*")
//@Configuration
public class UrlFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("----------------------->过滤器被创建");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();
        System.out.println("--------------------->过滤器：请求地址"+requestURI);
        String accessToken = req.getHeader("accessToken");
        if(accessToken == null) {
        	
        } else {
        	chain.doFilter(request, response);
        }
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	

}
