package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.coupon;
import com.example.repos.CouponRepository;



@Service
public class CouponService {
	
	@Autowired CouponRepository repo;

	public int getCouponDistcount(String code)
	{		
		if(code.equals("NA") || code.equals("na") ||code.equals("nA") || code.equals("Na"))
		{
			return 0;
		}
		else
		{
			
			List<coupon> c = repo.findAll();
			for(coupon cp : c)
			{
				if(cp.getCouponcode().equals(code))
				{
					return cp.getCoupondiscount();
				}
			}
		}
		return 0;

	}
	
}

