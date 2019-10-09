package com.owner.test.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.owner.test.entity.User;
import com.owner.test.service.UserService;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
	private UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		
		String username = userDetails.getUsername();
		
		User user = userService.findUserByUsername(username);
		
		request.getSession().setAttribute("user", user);
	
		request.getServletContext().setAttribute("message", "恭喜登录成功！");
		request.getServletContext().setAttribute("url", "/");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/success");
		requestDispatcher.forward(request, response);

	}

}
