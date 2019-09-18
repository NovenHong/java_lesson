package com.owner.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.owner.test.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User> {

	List<User> findByUsername(String username);

	List<User> findByUsernameLike(String username);

	List<User> findByUsernameAndAccount(String username, float account);

}
