package com.bm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bm.entity.Customer;
import com.bm.repository.CustomerRepository;

@Service
public class CustomerService {
	
	final private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public Customer getByEmailAndPassword(String email, String password) {
		return customerRepository.findByEmailAndPassword(email, password); 
	}
	
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}
	
}
