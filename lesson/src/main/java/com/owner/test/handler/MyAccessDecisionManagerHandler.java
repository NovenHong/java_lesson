package com.owner.test.handler;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class MyAccessDecisionManagerHandler implements AccessDecisionManager {

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		 Collection<? extends GrantedAuthority> myRoles = authentication.getAuthorities();
		 
		 for (GrantedAuthority myRole : myRoles) {
			 for (ConfigAttribute configAttribute : configAttributes) {
				 if(configAttribute.getAttribute().equals(myRole.getAuthority())) {
					 return;
				 }
			 }
		 }
		 
		 throw new AccessDeniedException("没有权限");

	}

	@Override
	public boolean supports(ConfigAttribute arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
