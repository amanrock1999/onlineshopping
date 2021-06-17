package com.example.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.coupon;

@Repository
public interface CouponRepository extends JpaRepository<coupon, String> {

}
