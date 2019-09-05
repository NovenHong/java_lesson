package com.spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.owner.test.entity.User;
import com.owner.test.service.UserService;

public class UserServiceTest {

	@SuppressWarnings("resource")
	@Test
	public void test01() {
		ApplicationContext ctx = null;
		
		ctx = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
		
		//UserService userService = (UserService) ctx.getBean("userService");
		UserService userService = (UserService) ctx.getBean("userService");
		
		User user = new User();
		user.setUsername("nana");
		user.setPassword("123456");
		user.setStatus(1);
		user.setCreateTime(System.currentTimeMillis() / 1000);
		
		userService.insertUser(user);
	}
	
	@SuppressWarnings("resource")
	@Test
	public void test02() {
		
		ApplicationContext ctx = null;
		
		ctx = new ClassPathXmlApplicationContext("spring/spring-*.xml");
		
		UserService userService = (UserService) ctx.getBean("userService");
		
		userService.updateAccount();
	}
}
