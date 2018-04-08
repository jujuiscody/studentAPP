package com.app.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.demo.model.Customer;

@Repository
public interface CustomerRepositry extends JpaRepository<Customer, Long> {

}
