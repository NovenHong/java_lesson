package com.mybatis.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import com.owner.test.entity.Role;
import com.owner.test.service.RoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class RoleServiceTest {

	@Resource(name="roleService")
	private RoleService roleService;
	
	@Test
	public void test01() {
		
		List<Role> roles = roleService.findAllRoleByPermissionUrl("/");
		
		System.out.println(roles);
	}
	
	@Test
	public void test02() {
		int count = StringUtils.countOccurrencesOf("/user", "/");
		
		System.out.println(count);
	}
	
	@Test
	public void test03() {
		
		List<Role> roles = roleService.findAllRoleByUserName("nana1");
		
		System.out.println(roles);
	}
}
