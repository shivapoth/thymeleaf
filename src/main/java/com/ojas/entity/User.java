package com.ojas.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@Column(name = "First_Name")
	private String fisrtName;
	@Column(name = "Last_Name")
	private String lastName;
	@Column(name = "Sur_Name")
	private String surName;
	@Column(name = "Date_of_Birth")
	private Date dateOfBirth;
	@Column(name = "City_Name")
	private String cityName;

	public User(String fisrtName, String lastName, String surName, Date dateOfBirth, String cityName) {
		super();
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.surName = surName;
		this.dateOfBirth = dateOfBirth;
		this.cityName = cityName;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
