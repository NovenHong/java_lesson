package com.owner.test.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.owner.test.entity.Address;
import com.owner.test.mapper.AddressMapper;

@Service("addressService")
public class AddressService {
	
	@Resource
	private AddressMapper addressMapper;
	
	public void insertAddress(Address address) {
		
		address.setCreateTime(new Long(new Date().getTime()).intValue());
		
		this.addressMapper.insert(address);
	}
}
