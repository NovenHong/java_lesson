package com.owner.test.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.owner.test.entity.Role;
import com.owner.test.mapper.RoleMapper;

@Service("roleService")
public class RoleService {
	
	@Resource
	private RoleMapper roleMapper;
	
	public Role findRoleByPrimaryId(int id) {
		return roleMapper.getRoleByPrimaryId(id);
	}
}
