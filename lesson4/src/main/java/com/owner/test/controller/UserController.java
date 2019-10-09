package com.owner.test.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.owner.test.entity.User;
import com.owner.test.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request,String username,String password,Map<String, String> map) {
		
		if(request.getMethod().equals(RequestMethod.POST.toString())) {
			
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			
			userService.insertUser(user);
			
			if(user.getId() > 0) {
				
				//注册session
				request.getSession().setAttribute("user", user);
				
				map.put("message", "恭喜，注册成功");
				map.put("url", "/");
				return "common/success";
			}else {
				map.put("message", "注册失败");
				map.put("url", "user/register");
				return "common/error";
			}
			
		}else {
			
			return "user/register";
		}
		
	}
}
