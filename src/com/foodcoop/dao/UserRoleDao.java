package com.foodcoop.dao;

import java.util.List;

import com.foodcoop.domain.UserRole;

public interface UserRoleDao {
	 public void insertData(UserRole userrole);
	 public void updateData(UserRole userRole);
	 public void deleteData(String id);
	 public List<UserRole> getUserRoleListByUser(int idUser);
	 public UserRole getUserRole(String id);
	 public UserRole getUserRole(String idUser, int idRole); 
}
