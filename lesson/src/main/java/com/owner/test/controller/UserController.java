package com.owner.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.owner.test.entity.Address;
import com.owner.test.entity.User;
import com.owner.test.service.AddressService;
import com.owner.test.service.UserService;
import com.owner.test.validator.group.UserAddGroup;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="addressService")
	private AddressService addressService;

	@RequestMapping("/index")
	public String index(@RequestParam(value="page",required=false,defaultValue="1") Integer page,
			@RequestParam(value="pageSize",required=false,defaultValue="20") Integer pageSize,Map<String, Object> map ) {
		
		PageHelper.startPage(1, 2);
		
		List<User> users = userService.queryAllUser();
		
		PageInfo<User> pageInfo = new PageInfo<User>(users);
		
//		System.out.println(pageInfo.getTotal());
//		System.out.println(pageInfo.getPages());
		
		map.put("data", users);
		
		return "user/index";
	}
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request,@Validated(value= {UserAddGroup.class}) User user,BindingResult bindingResult,Map<String, String> map) {
		
		if(request.getMethod().equals(RequestMethod.POST.toString())) {
			
			if(bindingResult.hasErrors()) {
				map.put("message", bindingResult.getFieldError().getDefaultMessage());
				//map.put("url", "user/register");
				return "common/error";
			}
			
			userService.insertUser(user);
			
			for(Address address : user.getAddressList()) {
				address.setUserId(user.getId());
				
				if(address.getCountry() != "" && address.getCity() != "") {
					addressService.insertAddress(address);
				}
			}
			
			if(user.getId() > 0) {
				
				//注册session
				request.getSession().setAttribute("user", user);
				
				map.put("message", "恭喜，注册成功");
				map.put("url", "");
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
			
			//System.out.println("ok1");
			
			//验证是否已经登录
			if(request.getSession().getAttribute("user") != null) {
				return "redirect:/";
			}
			
			return "user/login";
		}
	}
	
	@RequestMapping("/upload")
	public String upload(HttpServletRequest request,MultipartFile uploadfile) {
		if(request.getMethod().equals(RequestMethod.POST.toString())) {
			
			String originalFilename = uploadfile.getOriginalFilename();
			
			String filename = UUID.randomUUID()+originalFilename.substring(originalFilename.indexOf("."));
			
			String path = request.getServletContext().getRealPath("/WEB-INF/upload");
			
			System.out.println(path);
			
			System.out.println(filename);
			
			try {
				uploadfile.transferTo(new File(path+"/"+filename));
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "user/upload";
		}else {
			return "user/upload";
		}
	}
	
	@RequestMapping("/template")
	public String template() {
		return "user/template";
	}
	
}
