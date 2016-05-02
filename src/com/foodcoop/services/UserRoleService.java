package com.foodcoop.services;

import java.util.List;

import com.foodcoop.domain.Unit;
import com.foodcoop.domain.UserRole;

public interface UserRoleService {
	 public void insertData(UserRole userrole);
	 public void updateData(UserRole userRole);
	 public void deleteData(String id);
	 public List<UserRole> getUserRoleListByUser(int idUser);
	 public UserRole getUserRole(String id);
}
