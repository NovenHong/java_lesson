package com.owner.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.owner.test.entity.User;

public interface UserMapper {

	public void insertUser(User user);
	
	public List<User> queryAllUser();
	
	public User queryUserWithAddressByPrimaryId(int id);

	public void addOneHundred();

	public void subOneHundred();

	public User getUserForLogin(@Param("username")String username,
			@Param("password")String password);
}
