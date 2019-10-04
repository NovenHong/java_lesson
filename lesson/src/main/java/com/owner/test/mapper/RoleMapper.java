package com.owner.test.mapper;

import java.util.List;

import com.owner.test.entity.Role;

public interface RoleMapper {

	public Role getRoleByPrimaryId(int id);
	
	public List<Role> getAllRoleByPermissionUrl(String url);
	
	public List<Role> getAllRoleByUserName(String username);
}
