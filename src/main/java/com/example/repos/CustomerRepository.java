package com.example.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{

}
