package com.owner.test.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.owner.test.entity.User;
import com.owner.test.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;

	@RequestMapping("/index")
	public void index() {
		
		int i = 1 / 0;
		
		User user = new User();
		user.setUsername("nana");
		user.setPassword("123456");
		user.setStatus(1);
		user.setCreateTime(System.currentTimeMillis() / 1000);
		
		this.userService.insertUser(user);
		//System.out.println("ok...");
	}
}
