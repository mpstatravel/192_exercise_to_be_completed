package net.icdpublishing.exercise2.myapp.controllers;

import java.util.Collection;

import net.icdpublishing.exercise2.myapp.SearchRequest;
import net.icdpublishing.exercise2.myapp.services.CustomerService;
import net.icdpublishing.exercise2.myapp.services.ManageResultsService;
import net.icdpublishing.exercise2.myapp.services.impl.CustomerServiceImpl;
import net.icdpublishing.exercise2.myapp.services.impl.ManageResultsServiceImpl;
import net.icdpublishing.exercise2.searchengine.domain.Record;
import net.icdpublishing.exercise2.searchengine.services.SearchEngineRetrievalService;


public class MySearchController {
	
	private SearchEngineRetrievalService retrievalService;
	private ManageResultsService manageResultsService;
	private CustomerService customerService;
	
	public MySearchController(SearchEngineRetrievalService retrievalService, 
							  ManageResultsServiceImpl filterResultsService,
							  CustomerServiceImpl customerService) {
		this.retrievalService = retrievalService;
		this.manageResultsService = filterResultsService;
		this.customerService = customerService;
	}
	
	public Collection<Record> handleRequest(SearchRequest request) {
		Collection<Record> resultSet = getResults(request);
		return resultSet;
	}
	
	private Collection<Record> getResults(SearchRequest request) {
		
		Collection<Record> records  = retrievalService.search(request.getQuery());
		
		return manageResultsService.manage(records, request.getCustomer());	
		
	}
	
	
}