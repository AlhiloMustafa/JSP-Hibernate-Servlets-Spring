package com.hcl.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.springdemo.entity.Customer;
import com.hcl.springdemo.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	

	
	//inject CustomerService
	
	@Autowired 
	private CustomerService customerService;
	
	
	@GetMapping("/login")
	public String login(Model themodel) {
		
		
		System.out.println("login function");
		
		return "login";
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String customeremail,@RequestParam("password") String enteredPassword,Model themodel) {
		
		boolean isValidUser=customerService.validateUser(customeremail,enteredPassword);
		
		System.out.println("if valde or not:"+isValidUser);
		
		if (!isValidUser) {
			
			themodel.addAttribute("errorMessage", "Invalid Credentials");
			
			return "login";
		}
		
		themodel.addAttribute("welcomemail",customeremail);
		
		return "redirect:/customer/list";
		
	}
	
	
	
	
	@GetMapping("/list")
	public String listCustomers(Model themodel) {
		
		
		//1-get Customer from DAO
		//2-Add to MVC model
		
		//1
		List<Customer> theCustomers= customerService.getCustomers();
		
		
		//2
		themodel.addAttribute("customers",theCustomers);
		
		
		
		return "list-customers";
	}
	
	
	@GetMapping("/newuserform")
	public String userform(Model themodel) {
		
		Customer theCustomer=new Customer();
		
		themodel.addAttribute("customer", theCustomer);
		
		return "newuserform";
	
	}
	
	@PostMapping ("/savenewuser")
	public String savenewuser(@ModelAttribute("customer") Customer thecustomer) {
		
		
		customerService.saveCustomer(thecustomer);
		
	
		return "redirect:/customer/list";
		
	}
	
	
	@GetMapping("/updateform")
	public String updateform(@RequestParam("customerId") int customerid,Model themodel ) {
		
		
		
		Customer customerFromDB=customerService.getCustomer(customerid);
		
		themodel.addAttribute("customer", customerFromDB);
		
	
		return "newuserform";
	
	}
	

	
	

}
