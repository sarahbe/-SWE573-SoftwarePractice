package com.foodcoop.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
//This is our user class which contains only properties
public class User implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private Date registerationDate;
	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	private String gender;

	@NotEmpty(message = "Please enter your email addresss.")
	@Email
	private String email;

	@NotNull
	@Size(
			min = 4,
			max = 14)
	private String password;

	@Min(1925)
	private int birthYear;

	private boolean active;

	private String profilePicture;

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
}
