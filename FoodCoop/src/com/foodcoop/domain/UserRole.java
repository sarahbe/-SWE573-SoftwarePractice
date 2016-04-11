package com.foodcoop.domain;

public class UserRole {
private int id; 
private int userId;
private int roleId;
private boolean valid;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public int getRoleId() {
	return roleId;
}

public void setRoleId(int roleId) {
	this.roleId = roleId;
}
public boolean getValid() {
	return this.valid;
}

public void setValid(boolean valid) {
	this.valid = valid;
}
}
