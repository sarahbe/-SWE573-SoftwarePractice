package com.foodcoop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodcoop.dao.UserRoleDao;
import com.foodcoop.domain.Unit;
import com.foodcoop.domain.UserRole;

public class UserRoleServiceImpl implements UserRoleService{

	 @Autowired
	 UserRoleDao userRoledao;

	 @Override
	 public void insertData(UserRole userRole) {
	  userRoledao.insertData(userRole);
	 }

	 @Override
	 public void deleteData(String id) {
		 userRoledao.deleteData(id);
	  
	 }

	 @Override
	 public List<UserRole> getUserRoleListByUser(int idUser) {
	  return userRoledao.getUserRoleListByUser( idUser);
	 }

	 
	 @Override
	 public UserRole getUserRole(String id) {
	  return userRoledao.getUserRole(id);
	 }

	 @Override
	 public void updateData(UserRole userRole) {
		 userRoledao.updateData(userRole);
	  
	 }

}
