package com.example.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.AdminUser;

@Repository
public interface AdminRepository extends JpaRepository<AdminUser, String>{

}
