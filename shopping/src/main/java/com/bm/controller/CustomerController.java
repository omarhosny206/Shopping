package com.bm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bm.entity.Customer;
import com.bm.service.CustomerService;

@RestController
@RequestMapping("/customer/v1")
public class CustomerController {
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/{email}/{password}")
	public ResponseEntity<Customer> getByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
		Customer customer = customerService.getByEmailAndPassword(email, password);
		if (customer != null) {
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/")
	public Customer save(@RequestBody Customer customer) {
		return customerService.save(customer);
	}
}
