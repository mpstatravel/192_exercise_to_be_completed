package net.icdpublishing.exercise2.myapp.customers.dao;

import static org.junit.Assert.*;

import net.icdpublishing.exercise2.myapp.customers.dao.impl.CustomerDaoImpl;
import net.icdpublishing.exercise2.myapp.customers.domain.Customer;
import net.icdpublishing.exercise2.myapp.customers.domain.CustomerType;

import org.junit.Before;
import org.junit.Test;

public class CustomerDaoImplTest {

	private CustomerDaoImpl customerImpl;
	
	@Before
	public void setUp() throws Exception {
		customerImpl = new CustomerDaoImpl();
	}

	@Test
	public void shouldReturnExpectedCustomer() {
		Customer customer = customerImpl.findCustomerByEmailAddress("john.doe@192.com");
		assertEquals(customer, getExpectedCustomer());
	}

	@Test(expected=CustomerNotFoundException.class)
	public void shouldThrowCustomerNotFoundException() {
		customerImpl.findCustomerByEmailAddress("invalid_customer@192.com");
	}
	
	private Customer getExpectedCustomer() {
		Customer expectedCustomer = new Customer();
		expectedCustomer.setEmailAddress("john.doe@192.com");
		expectedCustomer.setForename("John");
		expectedCustomer.setSurname("Doe");
		expectedCustomer.setCustomType(CustomerType.PREMIUM);
		expectedCustomer.setCredits(192);
		return expectedCustomer;
	}
}