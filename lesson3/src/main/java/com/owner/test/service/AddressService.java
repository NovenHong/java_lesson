package com.owner.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owner.test.dao.AddressRepository;
import com.owner.test.entity.Address;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public Address findUserByPrimaryId(int id) {

		return addressRepository.findById(id).get();
	}
}
