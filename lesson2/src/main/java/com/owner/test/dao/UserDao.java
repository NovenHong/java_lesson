package com.owner.test.dao;

import com.owner.test.entity.User;

public interface UserDao {

	User findUserByPrimaryId(int id);

	void insertUser(User user);

	void deleteUser(User user);

	User getUserForLogin(String username, String password);
}
