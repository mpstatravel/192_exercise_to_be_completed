package net.icdpublishing.exercise2.myapp.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.icdpublishing.exercise2.myapp.charging.services.ChargingService;
import net.icdpublishing.exercise2.myapp.customers.domain.Customer;
import net.icdpublishing.exercise2.myapp.customers.domain.CustomerType;
import net.icdpublishing.exercise2.myapp.services.ManageResultsService;
import net.icdpublishing.exercise2.searchengine.domain.Record;
import net.icdpublishing.exercise2.searchengine.domain.SourceType;

/**
 * 
 * @author Michael Papamichael
 *
 */
public class ManageResultsServiceImpl implements ManageResultsService {
	
	private ChargingService chargingService;
	
	public ManageResultsServiceImpl(){
		super();
	}
	
	public ManageResultsServiceImpl(ChargingServiceImpl chargingServiceImpl) {
		this.chargingService = chargingServiceImpl;
	}

	@Override
	public List<Record> manage(Collection<Record> results, Customer customer) {
		
		if(results == null || customer == null){
			throw new IllegalArgumentException();
		}
		
		List<Record> records = new ArrayList<Record>();
		int chargableCredits = 0;
		int customerTotalCredits = customer.getCredits();

		for (Record record : results) {

			// BT is available for all customers so we add them to our list
			if (record.getSourceTypes() != null && record.getSourceTypes().contains(SourceType.BT)) {

				records.add(record);

				// any other source type is available for premium only
			} else if (customer.getCustomType() == CustomerType.PREMIUM && customerTotalCredits > 0) {

				records.add(record);

				customerTotalCredits--;
				
				chargableCredits ++;
			}

		}
		
		//charge customer
		chargingService.charge(customer.getEmailAddress(), chargableCredits);
		
		//sort collections
		Collections.sort(records, new RecordComparator());
		
		return records;

	}
	
	

}


