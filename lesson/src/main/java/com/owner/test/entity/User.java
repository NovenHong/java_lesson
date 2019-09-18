package com.owner.test.entity;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import com.owner.test.validator.group.UserAddGroup;

public class User {
	
	private int id;
	
	@NotBlank(message="{username.NotBlank}",groups= {UserAddGroup.class})
	@Pattern(regexp="^[A-Za-z]{1}[A-Za-z0-9_-]{3,15}$",groups= {UserAddGroup.class},message="{username.RegExp}")
	private String username;
	
	@NotBlank(message="{password.NotBlank}",groups= {UserAddGroup.class})
	@Pattern(regexp="(?=^.{6,16}$)(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).*$",groups= {UserAddGroup.class},message="{password.RegExp}")
	private String password;
	
	private float account;

	@PositiveOrZero
	private int status;
	
	private long createTime;
	
	private List<Address> addressList;
	
	private Set<Address> addressSet;
	
	private List<Role> roleList;
	
	public User() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float getAccount() {
		return account;
	}

	public void setAccount(float account) {
		this.account = account;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	

	public Set<Address> getAddressSet() {
		return addressSet;
	}

	public void setAddressSet(Set<Address> addressSet) {
		this.addressSet = addressSet;
	}
	

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", account=" + account
				+ ", status=" + status + ", createTime=" + createTime + ", addressList=" + addressList + ", addressSet="
				+ addressSet + ", roleList=" + roleList + "]";
	}
	
	
}
