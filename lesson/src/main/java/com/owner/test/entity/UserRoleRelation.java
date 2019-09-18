package com.owner.test.entity;

public class UserRoleRelation {
	
	private int id;
	
	private User user;
	
	private Role role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRoleRelation [id=" + id + ", user=" + user + ", role=" + role + "]";
	}
	
	
}
