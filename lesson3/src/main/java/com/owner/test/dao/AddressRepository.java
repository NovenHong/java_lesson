package com.owner.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.owner.test.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
