package com.foodcoop.services;

import com.foodcoop.domain.UserRole;

public interface UserRoleService {
	 public void insertData(UserRole userrole);
	 public void updateData(UserRole userRole);
	 public void deleteData(String id);
	 public UserRole getUserRole(String id);
}
