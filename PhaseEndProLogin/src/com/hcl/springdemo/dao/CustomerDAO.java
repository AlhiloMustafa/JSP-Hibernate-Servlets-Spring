package com.hcl.springdemo.dao;

import java.util.List;

import com.hcl.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer thecustomer);

	public Customer getCustomer(int customerid);

	public boolean validateUser(String customeremail, String enteredPassword);
	
	


}
