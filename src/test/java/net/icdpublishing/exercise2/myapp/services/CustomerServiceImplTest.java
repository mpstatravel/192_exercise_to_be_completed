package net.icdpublishing.exercise2.myapp.services;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import net.icdpublishing.exercise2.myapp.customers.dao.CustomerDao;
import net.icdpublishing.exercise2.myapp.customers.dao.CustomerNotFoundException;
import net.icdpublishing.exercise2.myapp.customers.domain.Customer;
import net.icdpublishing.exercise2.myapp.services.impl.CustomerServiceImpl;

/**
 * 
 * @author Michael Papamichael
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {
	
	@InjectMocks
	private CustomerService customerService= new CustomerServiceImpl();
	
	@Mock
	private CustomerDao customerDao;
	
	private Customer customer;
	
	@Before
	public void setUp() throws Exception {
		 MockitoAnnotations.initMocks(this);
		 initializeObjects();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shoultThrowExceptionWhenAuthenticate(){
		
		customerService.authenticate(null);
		
	}
		
	@Test
	public void shouldAuthenticate(){
		
		when(customerDao.findCustomerByEmailAddress(Matchers.anyString())).thenReturn(this.customer);
		
		customerService.authenticate("");
		
		verify(customerDao, times(1)).findCustomerByEmailAddress(Matchers.anyString());
	}
	
	
	
	public void initializeObjects(){
		
		Customer customer = new Customer();
		
	}
	
	
	
	

}
