package com.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.owner.test.entity.Address;
import com.owner.test.entity.User;

public class UserMapperTest {

	@Test
	public void test01() throws IOException {
		String resource = "mybatis/mybatis-config.xml";
		
		InputStream is = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setUsername("nana");
		user.setPassword("123456");
		user.setStatus(1);
		user.setCreateTime(System.currentTimeMillis() / 1000);
		
		sqlSession.insert("com.owner.test.mapper.UserMapper.insertUser",user);
		
		System.out.println(user.getId());
	
	}
	
	@Test
	public void test02() throws IOException {
		String resource = "mybatis/mybatis-config.xml";
		
		InputStream is = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		List<User> users = sqlSession.selectList("com.owner.test.mapper.UserMapper.queryAllUser");
		
		for(User user : users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void test03() throws IOException {
		String resource = "mybatis/mybatis-config.xml";
		
		InputStream is = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = sqlSession.selectOne("com.owner.test.mapper.UserMapper.queryUserWithAddressByPrimaryId", 1);
		
		for(Address address : user.getAddressList()) {
			System.out.println(address);
		}
	}
	
	
}
