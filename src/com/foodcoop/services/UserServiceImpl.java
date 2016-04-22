package com.foodcoop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodcoop.dao.UserDao;
import com.foodcoop.dao.UserRoleDao;
import com.foodcoop.domain.User;
import com.foodcoop.domain.UserRole;


public class UserServiceImpl implements UserService {

 @Autowired
 UserDao userdao;
 @Autowired
 UserRoleDao userRoleDao;
 
 @Override
 public void insertData(User user) {
  userdao.insertData(user);
 }

 @Override
 public List<User> getUserList() {
  return userdao.getUserList();
 }

 @Override
 public void deleteData(String id) {
  userdao.deleteData(id);
  
 }

 @Override
 public User getUser(String id) {
  return userdao.getUser(id);
 }

 @Override
 public void updateData(User user) {
  userdao.updateData(user);
  
 }
@Override
public void approveUser(String userId)
	{
	userdao.activateUser(Integer.parseInt(userId));
	UserRole userrole = new UserRole();
	userrole.setUserId(Integer.parseInt(userId));
	userrole.setRoleId(1);
	userRoleDao.insertData(userrole);
	}
 
 @Override
 public User getUserByEmail(String email, String password)
 {
	 return userdao.getUserByEmail(email, password);
 }

 
}

