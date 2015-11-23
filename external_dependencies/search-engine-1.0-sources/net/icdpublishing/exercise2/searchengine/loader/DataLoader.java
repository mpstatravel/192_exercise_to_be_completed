package net.icdpublishing.exercise2.searchengine.loader;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import net.icdpublishing.exercise2.searchengine.domain.Address;
import net.icdpublishing.exercise2.searchengine.domain.Person;
import net.icdpublishing.exercise2.searchengine.domain.Record;
import net.icdpublishing.exercise2.searchengine.domain.SourceType;

public class DataLoader {
	public Collection<Record> loadAllDatasets() {
		Collection<Record> dataset = new LinkedList<Record>();
		
		Person p1 = new Person();
		p1.setForename("Alfred");
		p1.setMiddlename("Duncan");
		p1.setSurname("Smith");
		p1.setTelephone("07702828333");
		
		Address address1 = new Address();
		address1.setBuildnumber("1");
		address1.setPostcode("sw6 2bq");
		address1.setStreet("william morris way");
		address1.setTown("London");
		p1.setAddress(address1);
		
		Set<SourceType> sources1 = new HashSet<SourceType>();
		sources1.add(SourceType.BT);
		sources1.add(SourceType.DNB);
		sources1.add(SourceType.ELECTORAL_ROLL);
		Record r1 = new Record(p1,sources1);
		
		Person p2 = new Person();
		p2.setForename("Mary");
		p2.setMiddlename("Ann");
		p2.setSurname("Smith");
		p2.setTelephone("07702811339");
		
		Address address2 = new Address();
		address2.setBuildnumber("13");
		address2.setPostcode("sw6 2bq");
		address2.setStreet("william morris way");
		address2.setTown("London");
		p2.setAddress(address2);
		
		Set<SourceType> sources2 = new HashSet<SourceType>();
		sources2.add(SourceType.BT);
		Record r2 = new Record(p2,sources2);
		
		Person p3 = new Person();
		p3.setForename("Sally");
		p3.setMiddlename("Janet");
		p3.setSurname("Cole");
		
		Address address3 = new Address();
		address3.setBuildnumber("4");
		address3.setPostcode("sw6 2bq");
		address3.setStreet("william morris way");
		address3.setTown("London");
		p3.setAddress(address3);
		
		Set<SourceType> sources3 = new HashSet<SourceType>();
		sources3.add(SourceType.ELECTORAL_ROLL);
		Record r3 = new Record(p3,sources3);
		
		Person p4 = new Person();
		p4.setForename("James");
		p4.setMiddlename("Harry");
		p4.setSurname("Smith");
		
		Address address4 = new Address();
		address4.setBuildnumber("17");
		address4.setPostcode("sw6 2bq");
		address4.setStreet("william morris way");
		address4.setTown("London");
		p4.setAddress(address4);
		
		Set<SourceType> sources4 = new HashSet<SourceType>();
		sources4.add(SourceType.DNB);
		sources4.add(SourceType.ELECTORAL_ROLL);
		Record r4 = new Record(p4,sources4);
	
		dataset.add(r1);
		dataset.add(r2);
		dataset.add(r3);
		dataset.add(r4);
		return Collections.unmodifiableCollection(dataset);
	}
}
