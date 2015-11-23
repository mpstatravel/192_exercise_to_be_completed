package net.icdpublishing.exercise2.searchengine.services;

import java.util.Collection;

import net.icdpublishing.exercise2.searchengine.domain.Record;
import net.icdpublishing.exercise2.searchengine.requests.SimpleSurnameAndPostcodeQuery;

public interface SearchEngineRetrievalService {
	/**
	 * Retrieves a collection of Records based on exact match on surname and postcode
	 * @param query 
	 * @return
	 */
	Collection<Record> search(SimpleSurnameAndPostcodeQuery query);
}