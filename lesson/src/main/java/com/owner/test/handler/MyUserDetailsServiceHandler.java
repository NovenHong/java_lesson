package com.owner.test.handler;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.owner.test.entity.Role;
import com.owner.test.service.RoleService;
import com.owner.test.service.UserService;

@Component
public class MyUserDetailsServiceHandler implements UserDetailsService {
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="roleService")
	private RoleService roleService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		List<Role> roles = roleService.findAllRoleByUserName(username);
		
		for(Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		com.owner.test.entity.User findUser = userService.findUserByUsername(username);
		
		User user = new User(username, findUser.getPassword(), authorities) ;
		
		return user;
		
	}

}
