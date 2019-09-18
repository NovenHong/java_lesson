package com.hibernate.test;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.owner.test.entity.User;
import com.owner.test.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class UserServiceTest {
	
	@Autowired
	private UserService userService;

	@Test
	public void test01() {
		User user = userService.findUserByPrimaryId(1);
		
		System.out.println(user);
	}
	
	@Test
	public void test02() {
		List<User> users = userService.findUserByUsername("nana1");
		
		System.out.println(users);
	}
	
	@Test
	public void test03() {
		List<User> users = userService.findUserByUsernameLike("King%");
		
		System.out.println(users);
	}
	
	@Test
	public void test04() {
		List<User> users = userService.findUserByUsernameAndAccount("nana1", 1);
		
		System.out.println(users);
	}
	
	@Test
	public void test05() {
		Page<User> userPage = userService.findUserList(1, 4, "","american");
		
		List<User> users = userPage.getContent();
		
		for (User user : users) {
			System.out.println(user);
		}
	}
	
}
