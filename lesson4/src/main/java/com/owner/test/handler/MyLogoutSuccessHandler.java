package com.owner.test.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		request.getServletContext().setAttribute("message", "退出登录成功！");
		request.getServletContext().setAttribute("url", "/user/login");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/success");
		requestDispatcher.forward(request, response);

	}

}
