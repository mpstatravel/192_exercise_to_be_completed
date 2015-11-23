package net.icdpublishing.exercise2.searchengine.requests;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SimpleSurnameAndPostcodeQuery {
	private String surname;
	private String postcode;
	
	public SimpleSurnameAndPostcodeQuery(String surname, String postcode) {
		this.surname = surname;
		this.postcode = postcode;
	}

	public String getSurname() {
		return surname;
	}

	public String getPostcode() {
		return postcode;
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
