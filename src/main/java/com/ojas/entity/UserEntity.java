package com.ojas.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="user")
public class UserEntity {
	
	@Id
	@Column(name = "First_Name")
	private String fisrtName;

	@Column(name = "Last_Name")
	private String lastName;

	@Column(name = "Sur_Name")
	private String surName;

	@Column(name = "Date_of_Birth")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	@Column(name = "City_Name")
	private String cityName;

	@Column(name = "User_Name")
	private String userName;

	@Column(name = "Password")
	private String password;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserEntity(String fisrtName, String lastName, String surName, Date dateOfBirth, String cityName,
			String userName, String password) {
		super();
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.surName = surName;
		this.dateOfBirth = dateOfBirth;
		this.cityName = cityName;
		this.userName = userName;
		this.password = password;
	}

	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
