package com.hibernate.test;

import java.util.Date;
import java.util.HashSet;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.owner.test.entity.Address;
import com.owner.test.entity.User;
import com.owner.test.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class UserDaoImplTest {
	
	@Resource(name="userService")
	private UserService userService;

	@Test
	public void test01() {
		User user = userService.findUserByPrimaryId(1);
		
		System.out.println(user);
	}
	
	@Test
	public void test02() {
		User user = new User();	
		user.setUsername("Test01");
		user.setPassword("123456");
		user.setStatus(1);
		user.setCreateTime(new Date().getTime()/1000);
		
		userService.insertUser(user);
	}
	
	//级联添加
	@Test
	public void test03() {
		User user = new User();	
		user.setUsername("Test01");
		user.setPassword("123456");
		user.setStatus(1);
		user.setCreateTime(new Date().getTime()/1000);
		
		Address address = new Address();
		address.setCountry("test country");
		address.setProvince("test province");
		address.setCity("test city");
		address.setStreet("test street");
		address.setCreateTime(new Date().getTime()/1000);
		
		HashSet<Address> addressSet = new HashSet<Address>();
		
		addressSet.add(address);
		
		user.setAddressSet(addressSet);
		
		userService.insertUser(user);
	}
	
	//级联删除
	@Test
	public void test04() {
		User user = userService.findUserByPrimaryId(11);
		
		userService.deleteUser(user);
	}
	
	
	
	
	
	
	
	
	
}
