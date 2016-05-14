package com.foodcoop.domain;

import java.io.Serializable;
import java.sql.Date;

//This is our user class which contains only properties
public class User implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private Date registerationDate;
    private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private String password;
	private int birthYear;
	private boolean active;
	private String profilePicture;
	private boolean memberActive;
	private boolean adminActive;
	private boolean salerActive; 
	private boolean stockerActive; 

	private int idRole; 
	
	public int getUserId() {
		return id;
	}

	public void setUserId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getProfilePicture() {
		return this.profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	

	public Date getRegisterationDate() {
		return this.registerationDate;
	}

	public void setRegisterationDate(Date registerationDate) {
		this.registerationDate = registerationDate;
	}
	
	public boolean getMemberActive() {
		return this.memberActive;
	}

	public void setMemberActive(boolean memberActive) {
		this.memberActive = memberActive;
	}

	public boolean getAdminActive() {
		return this.adminActive;
	}

	public void setAdminActive(boolean adminActive) {
		this.adminActive = adminActive;
	}


	public boolean getSalerActive() {
		return this.salerActive;
	}

	public void setSalerActive(boolean salerActive) {
		this.salerActive = salerActive;
	}


	public boolean getStockerActive() {
		return this.stockerActive;
	}

	public void setStockerActive(boolean stockerActive) {
		this.stockerActive = stockerActive;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	
}
