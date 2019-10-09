package com.owner.test.mapper;

import java.util.List;

import com.owner.test.entity.User;

public interface UserMapper {

	public void insertUser(User user);
	
	public User getUserByPrimaryId(int id);
	
	public List<User> queryAllUser();
	
	public List<User> queryUserWithRoleByPrimaryId(int id);

	public User getUserByUsername(String username);
}
