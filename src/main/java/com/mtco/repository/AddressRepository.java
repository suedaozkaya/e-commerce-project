package com.mtco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtco.domain.Address;
import com.mtco.domain.User;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByUser(User currentUser);

	
}
