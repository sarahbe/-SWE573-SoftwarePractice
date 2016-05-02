package com.foodcoop.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodcoop.dao.UserDao;
import com.foodcoop.dao.UserRoleDao;
import com.foodcoop.domain.Product;
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
	  List<User> userList = userdao.getUserList();
	
	   for(User item: userList)
	   {
		   List<UserRole> userroleList = userRoleDao.getUserRoleListByUser(item.getUserId());
		   for (UserRole roleItem : userroleList)
		   {
			   switch (roleItem.getRoleId()) {
	            case 1: item.setMemberActive(roleItem.getValid()) ;
	                     break;
	            case 2:  item.setAdminActive(roleItem.getValid());;
	                     break;
	            case 3: item.setSalerActive(roleItem.getValid());;
	                     break;
	            case 4:  item.setStockerActive(roleItem.getValid());;
	                     break;     
	        }
		   }
	   }
	   
  return userList;
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
public void grantUserRole(String userId, int idRole, boolean active)
	{
	UserRole userrole = userRoleDao.getUserRole(userId,idRole);
	
	userrole.setUserId(Integer.parseInt(userId));
	userrole.setRoleId(idRole);
	userrole.setValid(active);
	if (userrole.getId() > 0 ){
		userRoleDao.updateData(userrole);
	}
	else{
	userRoleDao.insertData(userrole);
	}
	}
 @Override
 public User getUserByEmail(String email, String password)
 {
	 return userdao.getUserByEmail(email, password);
 }

 
}

