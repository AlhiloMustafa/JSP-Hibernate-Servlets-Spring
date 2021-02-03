package com.hcl.springdemo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hcl.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	// inject Session Factory

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// 1-get session
		// 2-create query
		// 3-execute query
		// 4-return the list of customers
		//1
		Session currentSession = sessionFactory.getCurrentSession();
		//2
		Query<Customer> theQuery= currentSession.createQuery("from Customer",Customer.class);
		//3
		List<Customer> customers = theQuery.getResultList();
		//4
		return customers;

	}

	@Override
	public void saveCustomer(Customer thecustomer) {
		//1-get hibernate session
		//2-create query(save)
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(thecustomer);
	
		
	}

	@Override
	public Customer getCustomer(int customerid) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		Customer customerfromDB = currentSession.get(Customer.class, customerid);
		
		return customerfromDB;
	}

	@Override
	public boolean validateUser(String customeremail, String enteredPassword) {
		Session currentSession=sessionFactory.getCurrentSession();
		
		String hql="SELECT u.email,u.password FROM Customer u "
				+ "WHERE u.email = :customeremail "
				+ " and u.password = :password";
		
		Query<Customer> query = currentSession.createQuery(hql);
		query.setParameter("customeremail", customeremail);
		query.setParameter("password", enteredPassword);
		
		List<Customer> customer=query.getResultList();
		
		if(customer !=null && customer.size() >0) {
			
			return true;
			
			
		}

		
		return false;
	}

	
	
	
	
	
	
	
	
	
	
//	@Override
//	public boolean validateUser(String customeremail, String enteredPassword) {
//		Session currentSession=sessionFactory.getCurrentSession();
//		
//		String customeremail1="noor@gmail";
//		String enteredPassword1="1234$d";
//		String hql="SELECT u.id,u email FROM Customer u WHERE u.email=:customeremail and u.password =password";
//		
//		Query query = currentSession.createQuery(hql);
//		
//		query.setParameter("customeremail", customeremail1);
//		query.setParameter("password", enteredPassword1);
//		
//		
//		
//		List results = query.list();
//	
//		System.out.println(query);
//		
//		
//		return false;
//	}
//	
	



	
	
	

}
