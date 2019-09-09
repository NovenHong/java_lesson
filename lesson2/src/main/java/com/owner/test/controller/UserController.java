package com.owner.test.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.owner.test.entity.User;
import com.owner.test.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	

	@RequestMapping("/index")
	public void index() {
		
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,String username,String password,Map<String, String> map) {
		
		if(request.getMethod().equals(RequestMethod.POST.toString())) {
			
			if(username == "") {
				map.put("message", "用户名为空");
				map.put("url", "user/login");
				return "common/error";
			}
			if(password == "") {
				map.put("message", "用户密码为空");
				map.put("url", "user/login");
				return "common/error";
			}
			
			User user = userService.userLogin(username,password);
			
			if(user != null) {
				
				request.getSession().setAttribute("user", user);
				
				map.put("message", "恭喜，登录成功");
				map.put("url", "");
				return "common/success";
			}else {
				map.put("message", "登录失败，账号或者密码错误");
				map.put("url", "user/login");
				return "common/error";
			}
			
		}else {
			
			//验证是否已经登录
			if(request.getSession().getAttribute("user") != null) {
				return "redirect:/";
			}
			
			return "user/login";
		}
	}
	
}
