package com.owner.test.entity;

import java.util.List;
import java.util.Set;

public class User {
	
	private int id;

	private String username;
	
	private String password;
	
	private float account;

	private int status;
	
	private long createTime;
	
	private List<Address> addressList;
	
	private Set<Address> addressSet;
	
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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", account=" + account
				+ ", status=" + status + ", createTime=" + createTime + ", addressList=" + addressList + ", addressSet="
				+ addressSet + "]";
	}
	
	
}
