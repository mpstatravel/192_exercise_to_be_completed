package net.icdpublishing.exercise2.searchengine.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Record {
	private Person person;
	private Set<SourceType> sourceTypes;

	public Record(Person person, Set<SourceType> sourceTypes) {
		this.person = person;
		this.sourceTypes = new HashSet<SourceType>(sourceTypes);
	}

	public Person getPerson() {
		return person;
	}

	public Set<SourceType> getSourceTypes() {
		return Collections.unmodifiableSet(sourceTypes);
	}
	
	@Override
	public boolean equals(Object obj) {	
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
	@Override
	public int hashCode() {		
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}