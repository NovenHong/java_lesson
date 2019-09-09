package com.owner.test.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.owner.test.dao.UserDao;
import com.owner.test.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public User findUserByPrimaryId(int id) {
		
		return hibernateTemplate.get(User.class, id);
	}

	@Override
	public void insertUser(User user) {
		hibernateTemplate.save(user);
	}

	@Override
	public void deleteUser(User user) {
		hibernateTemplate.delete(user);
	}

	@Override
	public User getUserForLogin(String username, String password) {
		Session session = this.hibernateTemplate.getSessionFactory().getCurrentSession();
		
		Query query = session.createQuery("from User where username = :username and password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		
		return (User) query.getSingleResult();
	}

}
