package com.app.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.model.Customer;
import com.app.demo.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	// get all Customers 
	@GetMapping("/customers")
	//@RequestMapping(method=RequestMethod.GET)
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomers();
	}
	
	//  get Customer referring through ID
	@GetMapping("/customers/{id}")
	//@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Customer getByID(@PathVariable Long id) {
		return customerService.getByID(id);
	}
	
	// creating customer by request
	@PostMapping("/customers")
	//@RequestMapping(method=RequestMethod.POST)
	public Customer create(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	// updating existing customer
	@PutMapping("/customers/{id}")
	public Customer updateCustomer(@PathVariable long id, @RequestBody Customer customer) throws Exception{
		customer.setId(id);
		return customerService.modifyCustomer(id, customer);
	}
	
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable long id) throws Exception {
		this.customerService.deleteCustomer(id);
	}
	
	
}
