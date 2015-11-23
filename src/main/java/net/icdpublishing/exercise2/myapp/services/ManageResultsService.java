package net.icdpublishing.exercise2.myapp.services;

import java.util.Collection;
import java.util.List;

import net.icdpublishing.exercise2.myapp.customers.domain.Customer;
import net.icdpublishing.exercise2.searchengine.domain.Record;

public interface ManageResultsService {
	/**
	 * Used to filter records depending on customer type, and also to charge the customer depending on the records found.
	 * 
	 * @param rocords to filter by customer type
	 * @param customer to filter records with
	 * @return list of filtered customer
	 */
	List<Record> manage(Collection<Record> rocords, Customer customer);

}
