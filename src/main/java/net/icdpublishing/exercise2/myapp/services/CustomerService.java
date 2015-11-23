package net.icdpublishing.exercise2.myapp.services;

import net.icdpublishing.exercise2.myapp.customers.domain.Customer;

/**
 * 
 * @author mikelimassol
 *
 */
public interface CustomerService {

	/**
	 * Function to authenticate customer
	 * 
	 * @param email
	 *            to authenticate
	 * @return authenticated customer
	 */
	Customer authenticate(String email);

}
