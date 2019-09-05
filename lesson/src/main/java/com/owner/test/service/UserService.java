package com.owner.test.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.owner.test.entity.User;
import com.owner.test.mapper.UserMapper;

@Service("userService")
public class UserService {
	
	@Resource
	private UserMapper userMapper;
	
	public void insertUser(User user) {
		
		this.userMapper.insertUser(user);
	}
	
	public void updateAccount() {

		this.userMapper.addOneHundred();
		
		int i = 1 / 0;
		
		this.userMapper.subOneHundred();
	}
	
}
