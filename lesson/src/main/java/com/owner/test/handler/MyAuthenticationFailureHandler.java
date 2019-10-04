package com.owner.test.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex)
			throws IOException, ServletException {

		request.getServletContext().setAttribute("message", "账号或者密码错误！");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/error");
		requestDispatcher.forward(request, response);
		
	}

}
