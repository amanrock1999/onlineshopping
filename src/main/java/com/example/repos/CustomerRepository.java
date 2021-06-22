package com.example.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{

	List<Customer> findByAddress(String address);
	List<Customer> findByUserid(String userid);
}
