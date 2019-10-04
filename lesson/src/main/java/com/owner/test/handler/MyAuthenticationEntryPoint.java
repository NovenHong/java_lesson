package com.owner.test.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex)
			throws IOException, ServletException {
		
		request.getServletContext().setAttribute("message", "请先登录！");
		request.getServletContext().setAttribute("url", "/user/login");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error");
		requestDispatcher.forward(request, response);
	
	}

	
}
