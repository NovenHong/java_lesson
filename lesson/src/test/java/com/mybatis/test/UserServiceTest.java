package com.mybatis.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.owner.test.entity.Address;
import com.owner.test.entity.Role;
import com.owner.test.entity.User;
import com.owner.test.entity.UserRoleRelation;
import com.owner.test.service.AddressService;
import com.owner.test.service.RoleService;
import com.owner.test.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class UserServiceTest {
	
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="roleService")
	private RoleService roleService;
	
	@Resource(name="addressService")
	private AddressService addressService;

	@Test
	public void test01() {
		
		List<User> users = userService.findUserRoleByPrimaryId(1);
		
		System.out.println(users);
	}
	
	@Test
	public void test02() {
		
		UserRoleRelation userRoleRelation = new UserRoleRelation();
		
		User user = userService.findUserByPrimaryId(1);
		
		Role role = roleService.findRoleByPrimaryId(1);
		
		userRoleRelation.setUser(user);
		
		userRoleRelation.setRole(role);
		
		userService.deleteUserRoleByRelation(userRoleRelation);
		
	}
	
	@Test
	public void test03() {
		Address address = new Address();
		address.setUserId(1);
		address.setCity("test city");
		address.setCountry("test country");
		address.setProvince("test province");
		address.setStreet("test street");
		
		addressService.insertAddress(address);
	}
	
}
