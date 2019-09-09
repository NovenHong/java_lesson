package com.owner.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.owner.test.dao.UserDao;
import com.owner.test.entity.User;

@Service("userService")
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User findUserByPrimaryId(int id) {
		return userDao.findUserByPrimaryId(id);
	}

	public void insertUser(User user) {
		
		userDao.insertUser(user);
		
		//int i = 1 / 0;
	}

	public void deleteUser(User user) {
		
		userDao.deleteUser(user);
		
	}

	public User userLogin(String username, String password) {
		password = DigestUtils.md5DigestAsHex(password.getBytes());
		
		return this.userDao.getUserForLogin(username,password);
	}
}
