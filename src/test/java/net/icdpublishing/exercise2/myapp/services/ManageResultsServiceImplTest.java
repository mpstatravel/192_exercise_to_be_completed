package net.icdpublishing.exercise2.myapp.services;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import net.icdpublishing.exercise2.myapp.charging.services.ChargingService;
import net.icdpublishing.exercise2.myapp.customers.domain.Customer;
import net.icdpublishing.exercise2.myapp.customers.domain.CustomerType;
import net.icdpublishing.exercise2.myapp.services.impl.ManageResultsServiceImpl;
import net.icdpublishing.exercise2.searchengine.domain.Record;
import net.icdpublishing.exercise2.searchengine.loader.DataLoader;

/**
 * 
 * @author Michael Papamichael
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ManageResultsServiceImplTest {
	
	public static final int BT_SIZE = 2;
	public static final String SURNAME = "Cole";
	
	@InjectMocks
	private ManageResultsService manageResultsService = new ManageResultsServiceImpl();
	
	@Mock
	private ChargingService chargingService;
	
	@Before
	public void setUp() throws Exception {
		 MockitoAnnotations.initMocks(this);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldReturnIllegalArgumentexception(){
		
		manageResultsService.manage(null, null);
		
	}
	
	
	@Test
	public void shouldReturnBtRecordsOnlyIfNonPayingCustomers(){
		
	  DataLoader data =	new DataLoader();
	  
	  Customer customer = new Customer();
	  customer.setCredits(2);
	  customer.setCustomType(CustomerType.NON_PAYING); //Non Paying should return bt only customers
		
	  Collection<Record> records = manageResultsService.manage(data.loadAllDatasets(), customer);
	  
	  assertEquals(BT_SIZE, records.size());
	  
	}
	
	
	@Test
	public void shouldReturnAllRecordsIfCustomerIsPremiumAndHasEnoughCredits(){
		
	  DataLoader data =	new DataLoader();
	  
	  Customer customer = new Customer();
	  customer.setCredits(4);
	  customer.setCustomType(CustomerType.PREMIUM); //Non Paying should return all records
		
	  List<Record> records = manageResultsService.manage(data.loadAllDatasets(), customer);
	  
	  assertEquals(data.loadAllDatasets().size(), records.size());
	  
	  //check if the names are in asscending order
	  assertEquals(SURNAME,records.get(0).getPerson().getSurname());
	  
	}
	
	@Test
	public void shouldReturnThreeRecordsIfCustomerIsPremiumAndHasOneCredit(){
		
	  DataLoader data =	new DataLoader();
	  
	  Customer customer = new Customer();
	  customer.setCredits(1);
	  customer.setCustomType(CustomerType.PREMIUM);
		
	  Collection<Record> records = manageResultsService.manage(data.loadAllDatasets(), customer);
	  
	  assertEquals(3, records.size());
	  
	}
	
	
	

}
