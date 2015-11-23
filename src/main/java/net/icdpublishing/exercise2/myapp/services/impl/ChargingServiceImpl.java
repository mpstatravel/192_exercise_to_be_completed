package net.icdpublishing.exercise2.myapp.services.impl;

import net.icdpublishing.exercise2.myapp.charging.ChargingException;
import net.icdpublishing.exercise2.myapp.charging.services.ChargingService;
import net.icdpublishing.exercise2.myapp.customers.dao.CustomerDao;
import net.icdpublishing.exercise2.myapp.customers.dao.impl.CustomerDaoImpl;
import net.icdpublishing.exercise2.myapp.customers.domain.Customer;

/**
 * 
 * @author Michael Papamichael
 *
 */
public class ChargingServiceImpl implements ChargingService {

	CustomerDao customerDao;

	public ChargingServiceImpl() {
		super();
	};

	public ChargingServiceImpl(CustomerDaoImpl customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void charge(String email, int numberOfCredits) throws ChargingException {

		// verify email address and retrieve customer
		Customer customer = customerDao.findCustomerByEmailAddress(email);

		if(numberOfCredits > customer.getCredits()){
			throw new ChargingException("Number of Credits to be charged exceed the customers balance.");
		}
			
		// deduct units from customer
		customer.chargeCustomer(numberOfCredits);

	}

}
