package com.hcl.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.springdemo.dao.CustomerDAO;
import com.hcl.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	//1-inject customer DAO
	//2-return method getCustomers 
	
	@Autowired
	private CustomerDAO customerDAO;
	

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();

	}


	@Override
	@Transactional
	public void saveCustomer(Customer thecustomer) {
		customerDAO.saveCustomer(thecustomer);
		
	}


	@Override
	@Transactional
	public Customer getCustomer(int customerid) {
		Customer customerfromDB=customerDAO.getCustomer(customerid);
		return customerfromDB;
	}


	@Override
	@Transactional
	public boolean validateUser(String customeremail, String enteredPassword) {
		
		boolean isValid=customerDAO.validateUser(customeremail,enteredPassword);
		
		
		return isValid;
	}


	
	

}
