package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Customer;

/**
 * @author alka0
 * Repository class for storing, fetching and manipulating customer data
 */
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	public Customer findByUserName(String name);

}
