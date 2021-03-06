package com.owner.test.handler;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import com.google.code.kaptcha.Constants;

@Component
public class MyCodeValidatorProcessingFilter extends AbstractAuthenticationProcessingFilter {

	protected MyCodeValidatorProcessingFilter() {

		super(new AntPathRequestMatcher("/login", "POST"));
		
	}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		 HttpServletRequest req = (HttpServletRequest) request;  
		 HttpServletResponse res=(HttpServletResponse)response;
		 
		if(requiresAuthentication(req, res)) {
			
			String code = req.getParameter("code");
			
			if(!code.equals(req.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY))) {
				//unsuccessfulAuthentication(req,res,new InsufficientAuthenticationException("验证码错误"));
				
				req.getServletContext().setAttribute("message", "验证码错误！");
				
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("/error");
				requestDispatcher.forward(req, res);
				
				return;
			}
		}
		
		chain.doFilter(request, response);
	}



	@Override
	public Authentication attemptAuthentication(HttpServletRequest arg0, HttpServletResponse arg1)
			throws AuthenticationException, IOException, ServletException {
		System.out.println("attemptAuthentication");
		return null;
	}

}
