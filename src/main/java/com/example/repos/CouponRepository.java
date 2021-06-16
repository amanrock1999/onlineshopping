package com.example.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.models.coupon;

@Repository
@Transactional
public interface CouponRepository extends JpaRepository<coupon, String> {
	
	@Query("SELECT coupondiscount FROM coupon c WHERE c.couponcode=:n")
	int findByCode(@Param("n") String code);
	
	

}
