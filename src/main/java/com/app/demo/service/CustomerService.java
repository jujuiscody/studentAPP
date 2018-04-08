package com.app.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.repositry.CustomerRepositry;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepositry customerRepositry;

}
