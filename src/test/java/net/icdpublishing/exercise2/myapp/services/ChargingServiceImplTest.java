package net.icdpublishing.exercise2.myapp.services;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import java.util.regex.Matcher;

import net.icdpublishing.exercise2.myapp.charging.ChargingException;
import net.icdpublishing.exercise2.myapp.charging.services.ChargingService;
import net.icdpublishing.exercise2.myapp.customers.dao.CustomerDao;
import net.icdpublishing.exercise2.myapp.customers.domain.Customer;
import net.icdpublishing.exercise2.myapp.services.impl.ChargingServiceImpl;

/**
 * 
 * @author Michael Papamichael
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ChargingServiceImplTest {
	
	@InjectMocks
	private ChargingService chargingService = new ChargingServiceImpl();
	
	@Mock
	private CustomerDao customerDao;
	
	private Customer customer;
	
	@Before
	public void setUp() throws Exception {
		 MockitoAnnotations.initMocks(this);
		 initializeObjects();
		 
	}
	
	@Test(expected=ChargingException.class)
	public void shouldThrowChargingException(){
		
		when(customerDao.findCustomerByEmailAddress(Matchers.anyString())).thenReturn(this.customer);
		
		chargingService.charge("", 2);
		
	}
	
	@Test
	public void shouldChargeOneUnit() {
		
		when(customerDao.findCustomerByEmailAddress(Matchers.anyString())).thenReturn(this.customer);
		
		chargingService.charge("", 1);
		
		assertEquals(new Integer(0), customer.getCredits());
		
		
	}
	
	public void initializeObjects(){
		
		customer = new Customer();
		customer.setCredits(1);
		
	}
	
	

}
