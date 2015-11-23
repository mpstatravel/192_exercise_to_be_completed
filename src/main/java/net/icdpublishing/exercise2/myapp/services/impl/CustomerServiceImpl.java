package net.icdpublishing.exercise2.myapp.services.impl;

import net.icdpublishing.exercise2.myapp.customers.dao.CustomerDao;
import net.icdpublishing.exercise2.myapp.customers.dao.impl.CustomerDaoImpl;
import net.icdpublishing.exercise2.myapp.customers.domain.Customer;
import net.icdpublishing.exercise2.myapp.services.CustomerService;

/**
 * 
 * @author Michael Papamichael
 *
 */
public class CustomerServiceImpl implements CustomerService {
	
    CustomerDao customerDao;
    
    public CustomerServiceImpl(){
    	super();
    }
	
	public CustomerServiceImpl(CustomerDaoImpl customerDao){
		this.customerDao = customerDao;
	}

	@Override
	public Customer authenticate(String email) {
		
		if(email == null){
			throw new IllegalArgumentException();
		}
		
		return customerDao.findCustomerByEmailAddress(email);
		
	}

}
