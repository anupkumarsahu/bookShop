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
@Table(name="STATE")
public class State implements Serializable {

	private Integer stateNo;
	private String state;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STATENO")
	public Integer getStateNo() {
		return stateNo;
	}
	public void setStateNo(Integer stateNo) {
		this.stateNo = stateNo;
	}
	
	@Column(name="STATE")
	@NotEmpty(message="State name is mandatory")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
