package com.anup.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="PUBLISHERS")
public class Publisher implements Serializable {
	
	private Integer publisherNo;
	private String publisherName;
	private String address1;
	private String address2;
	private String city;
	private Integer stateNo;
	private String pincode;
	private Integer countryNo;
	private String emailAddress;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PUBLISHERNO")
	public Integer getPublisherNo() {
		return publisherNo;
	}
	public void setPublisherNo(Integer publisherNo) {
		this.publisherNo = publisherNo;
	}
	
	@Column(name="PUBLISHERNAME")
    @NotEmpty(message="Publisher name is mandatory")
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	
	@Column(name="ADDRESS1")
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	@Column(name="ADDRESS2")
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	@Column(name="CITY")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name="STATENO")
	public Integer getStateNo() {
		return stateNo;
	}
	public void setStateNo(Integer stateNo) {
		this.stateNo = stateNo;
	}
	
	@Column(name="PINCODE")
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	@Column(name="COUNTRYNO")
	public Integer getCountryNo() {
		return countryNo;
	}
	public void setCountryNo(Integer countryNo) {
		this.countryNo = countryNo;
	}
	
	@Column(name="EMAILADDRESS")
    @NotEmpty(message="Email address is mandatory")
    @Email(message="Invalid email address")
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
