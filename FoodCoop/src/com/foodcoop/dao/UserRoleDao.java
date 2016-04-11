package com.foodcoop.dao;

import com.foodcoop.domain.UserRole;

public interface UserRoleDao {
	 public void insertData(UserRole userrole);
	 public void updateData(UserRole userRole);
	 public void deleteData(String id);
	 public UserRole getUserRole(String id);
}
