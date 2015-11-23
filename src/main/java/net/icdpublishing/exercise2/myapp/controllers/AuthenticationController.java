package net.icdpublishing.exercise2.myapp.controllers;

import net.icdpublishing.exercise2.myapp.customers.dao.impl.CustomerDaoImpl;
import net.icdpublishing.exercise2.myapp.customers.domain.Customer;
import net.icdpublishing.exercise2.myapp.services.CustomerService;
import net.icdpublishing.exercise2.myapp.services.impl.CustomerServiceImpl;

/**
 * 
 * @author Michael Papamichael
 *
 */
public class AuthenticationController extends CustomerDaoImpl {

	private CustomerService customerService;

	public AuthenticationController(CustomerServiceImpl customerService) {
		this.customerService = customerService;
	}

	public Customer authenticate(String email) {
		return customerService.authenticate(email);
	}

}
