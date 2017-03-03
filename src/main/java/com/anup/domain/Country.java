package com.anup.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="COUNTRIES")
public class Country implements Serializable {

	private Integer countryNo;
	private String country;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COUNTRYNO")
	public Integer getCountryNo() {
		return countryNo;
	}
	public void setCountryNo(Integer countryNo) {
		this.countryNo = countryNo;
	}
	
	@Column(name="COUNTRY")
	@NotEmpty(message="Country name is mandatory")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
