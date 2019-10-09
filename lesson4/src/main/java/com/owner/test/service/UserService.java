package com.owner.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.owner.test.entity.User;
import com.owner.test.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public void insertUser(User user) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		user.setCreateTime(System.currentTimeMillis() / 1000);
		
		this.userMapper.insertUser(user);
	}
	
	public List<User> queryAllUser() {
		return userMapper.queryAllUser();
	}
	
	public List<User> findUserRoleByPrimaryId(int id) {
		return userMapper.queryUserWithRoleByPrimaryId(id);
	}
	
	public User findUserByPrimaryId(int id) {
		return userMapper.getUserByPrimaryId(id);
	}
	
	public User findUserByUsername(String username) {
		return userMapper.getUserByUsername(username); 
	}
	
}
