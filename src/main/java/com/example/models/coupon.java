package com.example.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class coupon {
	@Id
	private int couponid;
	
	@Override
	public String toString() {
		return "coupon [couponid=" + couponid + ", couponcode=" + couponcode + ", coupondiscount=" + coupondiscount
				+ "]";
	}

	public int getCouponid() {
		return couponid;
	}

	public void setCouponid(int couponid) {
		this.couponid = couponid;
	}

	public String getCouponcode() {
		return couponcode;
	}

	public void setCouponcode(String couponcode) {
		this.couponcode = couponcode;
	}

	public int getCoupondiscount() {
		return coupondiscount;
	}

	public void setCoupondiscount(int coupondiscount) {
		this.coupondiscount = coupondiscount;
	}

	@Column(length = 50)
	private String couponcode;
	 
	@Column
	private int coupondiscount;
	
	public coupon() {
		super();
	}
	
	
}

