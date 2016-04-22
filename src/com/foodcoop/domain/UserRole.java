package com.foodcoop.domain;
import java.io.Serializable;

public class UserRole implements Serializable{
	private static final long serialVersionUID = 1L;	
	
private int id; 
private int idUser;
private int idRole;
private boolean valid;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getUserId() {
	return idUser;
}

public void setUserId(int userId) {
	this.idUser = userId;
}

public int getRoleId() {
	return idRole;
}

public void setRoleId(int roleId) {
	this.idRole = roleId;
}
public boolean getValid() {
	return this.valid;
}

public void setValid(boolean valid) {
	this.valid = valid;
}
}
