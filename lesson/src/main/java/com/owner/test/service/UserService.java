package com.owner.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.owner.test.entity.Role;
import com.owner.test.entity.User;
import com.owner.test.entity.UserRoleRelation;
import com.owner.test.mapper.UserMapper;

@Service("userService")
public class UserService {
	
	@Resource
	private UserMapper userMapper;
	
	public void insertUser(User user) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		user.setCreateTime(System.currentTimeMillis() / 1000);
		
		this.userMapper.insertUser(user);
	}
	
	public void updateAccount() {

		this.userMapper.addOneHundred();
		
		int i = 1 / 0;
		
		this.userMapper.subOneHundred();
	}

	public User userLogin(String username, String password) {
		
		password = DigestUtils.md5DigestAsHex(password.getBytes());
		
		return this.userMapper.getUserForLogin(username,password);
	}
	
	public List<User> queryAllUser() {
		return userMapper.queryAllUser();
	}
	
	public List<User> findUserRoleByPrimaryId(int id) {
		return userMapper.queryUserWithRoleByPrimaryId(id);
	}
	
	public void deleteUserRoleByRelation(UserRoleRelation userRoleRelation) {
		userMapper.deleteUserRoleByRelation(userRoleRelation);
	}
	
	public User findUserByPrimaryId(int id) {
		return userMapper.getUserByPrimaryId(id);
	}
	
	public User findUserByUsername(String username) {
		return userMapper.getUserByUsername(username); 
	}
	
}
