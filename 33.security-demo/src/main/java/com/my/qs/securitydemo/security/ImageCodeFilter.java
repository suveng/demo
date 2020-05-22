package com.my.qs.securitydemo.security;

import org.apache.logging.log4j.util.Strings;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ImageCodeFilter extends OncePerRequestFilter {
	private static String IMAGE_CODE = "code";

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
		if (httpServletRequest.getRequestURI().equals("/login") && httpServletRequest.getMethod().equalsIgnoreCase("post")){
			String code = httpServletRequest.getParameter(IMAGE_CODE);
			if(Strings.isEmpty(code)){
				httpServletResponse.setCharacterEncoding("UTF-8");
				httpServletResponse.setContentType("application/json");
				httpServletResponse.getWriter().write("参数错误");
				return;
			}
			HttpSession session = httpServletRequest.getSession();
			StringBuffer image_code = (StringBuffer)session.getAttribute("IMAGE_CODE");
			if(Strings.isNotEmpty(image_code) && code.equalsIgnoreCase(image_code.toString())){
				filterChain.doFilter(httpServletRequest, httpServletResponse);
			}
			httpServletResponse.setCharacterEncoding("UTF-8");
			httpServletResponse.setContentType("application/json");
			httpServletResponse.getWriter().write("验证失败");
			return;
		}
		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
}
