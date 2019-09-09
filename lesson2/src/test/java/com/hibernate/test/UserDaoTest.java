package com.hibernate.test;

import java.util.Date;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.owner.test.entity.Address;
import com.owner.test.entity.User;

public class UserDaoTest {

	@Test
	public void test01() {
		
		Configuration configuration = new Configuration();
		
		configuration.configure("hibernate/hibernate.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.getTransaction();
		
		transaction.begin();
		
		User user = new User();
		
		user.setUsername("King Pineapple");
		user.setPassword("123456");
		user.setStatus(1);
		user.setCreateTime(new Date().getTime()/1000);
		
		session.save(user);
		
		transaction.commit();
		
		session.close();
		
	}
	
	@Test
	public void test02() {
		
		Configuration configuration = new Configuration();
		
		configuration.configure("hibernate/hibernate.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.getTransaction();
		
		transaction.begin();
		
		User user = session.get(User.class, 4);
		
		user.setUsername("King Threemelons");
		
		session.update(user);
		
		transaction.commit();
		
		session.close();
		
	}
	
	//级联查询
	@Test
	public void test03() {
		
		Configuration configuration = new Configuration();
		
		configuration.configure("hibernate/hibernate.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.getTransaction();
		
		transaction.begin();
		
		User user = session.get(User.class, 1);
		
		System.out.println(user);
		
		transaction.commit();
		
		session.close();
		
	}
	
	//级联保存
	@Test
	public void test04() {
		
		Configuration configuration = new Configuration();
		
		configuration.configure("hibernate/hibernate.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.getTransaction();
		
		transaction.begin();
		
		User user = new User();	
		user.setUsername("Test01");
		user.setPassword("123456");
		user.setStatus(1);
		user.setCreateTime(new Date().getTime()/1000);
		
		Address address = new Address();
		address.setCountry("test country");
		address.setProvince("test province");
		address.setCity("test city");
		address.setStreet("test street");
		address.setCreateTime(new Date().getTime()/1000);
		
		HashSet<Address> addressSet = new HashSet<Address>();
		
		addressSet.add(address);
		
		user.setAddressSet(addressSet);
		
		session.save(user);
		
		transaction.commit();
		
		session.close();
		
	}
	
	//级联删除
	@Test
	public void test05() {
		
		Configuration configuration = new Configuration();
		
		configuration.configure("hibernate/hibernate.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.getTransaction();
		
		transaction.begin();
		
		User user = session.get(User.class, 8);
		
		//System.out.println(user);
		
		session.delete(user);
		
		transaction.commit();
		
		session.close();
		
	}
}
