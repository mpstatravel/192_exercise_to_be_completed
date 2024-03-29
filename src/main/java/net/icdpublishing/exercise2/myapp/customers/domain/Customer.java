package net.icdpublishing.exercise2.myapp.customers.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Customer {

	private String forename;
	private String surname;
	private String emailAddress;
	private CustomerType customerType;
	private int credits;
	
	public String getForename() {
		return forename;
	}
	
	public void setForename(String forename) {
		this.forename = forename;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public CustomerType getCustomType() {
		return customerType;
	}

	public void setCustomType(CustomerType customType) {
		this.customerType = customType;
	}
	
	public Integer getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	public void chargeCustomer(int creditsToCharge){
		
		credits = credits - creditsToCharge;
		
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