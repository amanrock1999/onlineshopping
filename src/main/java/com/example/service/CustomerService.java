package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Customer;
import com.example.repos.CustomerRepository;

@Service
public class CustomerService {

	@Autowired CustomerRepository crepo;
	
	public List<Customer> allCustomers(){
		System.out.println("Here is the data from the mockito: "+crepo.findAll());
		return crepo.findAll();
	}
	
	public Customer findByUserId(String userid) {
		Optional<Customer> cust=crepo.findById(userid);
		if(cust.isPresent())
			return cust.get();
		else
			return null;
	}
	
	public List<Customer> getCustomerByUerid(String userid)
	{
		return crepo.findByUserid(userid);
	}
	
	public boolean updatePassword(String userid,String pwd,String opwd) {
		Customer c=findByUserId(userid);
		System.err.println(pwd);
		if(c.getPwd().equals(opwd)) {
			c.setPwd(pwd);
			crepo.save(c);
			return true;
		}
		return false;
	}
	
	public List<Customer> getCustomerByAddress(String address)
	{
		return crepo.findByAddress(address);
	}
	public void deleteCustomer(Customer cus)
	{
		crepo.delete(cus);
	}
	
	public String getCustAddress(String userid)
	{
		Customer c = findByUserId(userid);
		System.err.println(userid);
		if(c.getUserid().equals(userid))
		{
			return c.getAddress();
		}
		return "";
	}
	public String getCustLastName(String userid)
	{
		Customer c = findByUserId(userid);
		System.err.println(userid);
		if(c.getUserid().equals(userid))
		{
			return c.getLname();
		}
		return "";
	}
	
	public Customer ValidateLogin(String userid,String pwd) {
		Customer c=findByUserId(userid);
		if(c==null) {
			return null;
		}
		else  {
			if(c.getPwd().equals(pwd))
				return c;
			else 
				return null;
		}
	}
	
	public String VerifyUser(String userid) {
		if(findByUserId(userid)==null)
			return "ok";
		else
			return "no";
	}
	
	public Customer saveCustomer(Customer c) {
		return crepo.save(c);
	}
	
	public void changePassword(String userid,String pwd) {
		Customer c=findByUserId(userid);
		c.setPwd(pwd);
		crepo.save(c);
	}
	
	public boolean checkPassword(String userid,String old) {
		Customer c=findByUserId(userid);
		return c.getPwd().equals(old);
	}
}

