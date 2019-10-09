package com.owner.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.owner.test.entity.Role;
import com.owner.test.mapper.RoleMapper;

@Service
public class RoleService {
	
	@Autowired
	private RoleMapper roleMapper;
	
	public Role findRoleByPrimaryId(int id) {
		return roleMapper.getRoleByPrimaryId(id);
	}
	
	public List<Role> findAllRoleByPermissionUrl(String url){
	
		int count = StringUtils.countOccurrencesOf(url, "/");
		
		if(count == 1) {
			url = "/";
		}
		
		return roleMapper.getAllRoleByPermissionUrl(url);
	}
	
	public List<Role> findAllRoleByUserName(String username){
		
		return roleMapper.getAllRoleByUserName(username);
	}
}
