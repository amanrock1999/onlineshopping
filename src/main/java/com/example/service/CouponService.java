package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.coupon;
import com.example.repos.CouponRepository;



@Service
public class CouponService {
	
	@Autowired CouponRepository repo;

	public int coupondist(String code)
	{
		int cp = repo.findByCode(code);
		return cp;
	}
	
}

