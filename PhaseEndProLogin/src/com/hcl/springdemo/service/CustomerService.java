package com.hcl.springdemo.service;

import java.util.List;

import com.hcl.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer thecustomer);

	public Customer getCustomer(int customerid);

	public boolean validateUser(String customeremail, String enteredPassword);
	
	

}
