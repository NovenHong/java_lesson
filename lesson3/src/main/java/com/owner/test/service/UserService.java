package com.owner.test.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.owner.test.dao.UserRepository;
import com.owner.test.entity.Address;
import com.owner.test.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User findUserByPrimaryId(int id) {
		
		return userRepository.findById(id).get();
	}
	
	public List<User> findUserByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}
	
	public List<User> findUserByUsernameLike(String username){
		
		return userRepository.findByUsernameLike(username);
	}
	
	public List<User> findUserByUsernameAndAccount(String username,float account){
		return userRepository.findByUsernameAndAccount(username,account);
	}
	
	public Page<User> findUserList(Integer pageNum,Integer pageSize,String username,String country){
		Specification<User> specification = new Specification<User>() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				List<Predicate> predicates = new ArrayList<>();
				if(!StringUtils.isEmpty(username)) {
					Predicate usernameLike = builder.like(root.get("username"),username+"%");
					predicates.add(usernameLike);
				}
				
				if(!StringUtils.isEmpty(country)) {
					Join<User, Address> join = root.join("address",JoinType.LEFT);
					Predicate countryEqual = builder.equal(join.get("country"), country);
					predicates.add(countryEqual);
				}
				
				query.orderBy(builder.desc(root.get("id")));
				
				return builder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
			
		};
		
		PageRequest pageRequest = PageRequest.of(pageNum-1, pageSize);
		
		return userRepository.findAll(specification,pageRequest);
	}

}
