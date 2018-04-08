package com.app.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.model.Customer;
import com.app.demo.repositry.CustomerRepositry;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepositry customerRepositry;

	// getting all customer details from database
	public List<Customer> getAllCustomers(){
		return customerRepositry.findAll();
	}
	
	// getting single customer from database
	public Customer getByID(Long id) {
		return customerRepositry.findOne(id);
	}
	
	// adds customer to database 
	public Customer addCustomer(Customer customer) {
		return customerRepositry.save(customer);
	}
	
	public Customer modifyCustomer(Long id, Customer customer) throws Exception {
		
		Customer dbCustomer = this.getByID(id);
		
		if(dbCustomer == null) {
			throw new Exception("customer id: "+id+" is not found");
		}
		return customerRepositry.save(customer);
	}
	
	public void deleteCustomer(long id) throws Exception{
		Customer dbCustomer = this.getByID(id);
		if(dbCustomer == null) {
			throw new Exception("customer id: "+id +" is not found");
		}
		this.customerRepositry.delete(id);
		
	}
}
