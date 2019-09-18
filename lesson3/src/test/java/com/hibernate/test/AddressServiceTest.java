package com.hibernate.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.owner.test.entity.Address;
import com.owner.test.entity.User;
import com.owner.test.service.AddressService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class AddressServiceTest {

	@Autowired
	private AddressService addressService;
	
	@Test
	public void test01() {
		Address address = addressService.findUserByPrimaryId(1);
		
		System.out.println(address);
	}
}
