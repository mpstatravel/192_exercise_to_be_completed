package net.icdpublishing.exercise2.myapp.services.impl;

import java.util.Comparator;

import net.icdpublishing.exercise2.searchengine.domain.Record;

/**
 * Comparator to sort the records by customer surname 
 * @author mikelimassol
 *
 */
class RecordComparator implements Comparator<Record> {
    @Override
    public int compare(Record a, Record b) {
    	try{
    		return a.getPerson().getSurname().compareToIgnoreCase(b.getPerson().getSurname());
    	}catch(Exception ex){
    		return 0;
    	}
    }
}