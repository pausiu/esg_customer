package com.esg.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_CUSTOMER")
public class Customer {

	@Id
	@Column(name="CUSTOMER_REF", unique = true, nullable = false)
	private String customerRef;

	@Column(name = "CUSTOMER_NAME")
	private String customerName;

	@Column(name = "ADDRESS_LINE1")
	private String addressLine1;

	@Column(name = "ADDRESS_LINE2")
	private String addressLine2;

	@Column(name = "TOWN")
	private String town;

	@Column(name = "COUNTY")
	private String county;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "POSTCODE")
	private String postcode;
	
	public Customer() {

	}

	public Customer(String customerRef, String customerName, String addressLine1, 
			String addressLine2, String town, String county, String country, String postcode) {
		this.customerRef = customerRef;
		this.customerName = customerName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.town = town;
		this.county = county;
		this.country = country;
		this.postcode = postcode;
	}


	public String getCustomerRef() {
		return customerRef;
	}

	public void setCustomerRef(String customerRef) {
		this.customerRef = customerRef;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return "Customer [customerRef=" + customerRef + ", customerName=" + customerName 
				+ ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", town=" + town + ", county=" + county 
				+ ", country=" + country + ", postcode=" + postcode
				+ "]";
	}

}