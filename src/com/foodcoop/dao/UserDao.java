package com.foodcoop.dao;

import java.util.List;
import com.foodcoop.domain.User;
//This is an interface that contains unimplemented methods to perform CRUD
public interface UserDao {
 public void insertData(User user);
 public List<User> getUserList();
 public void updateData(User user);
 public void deleteData(String id);
 public User getUser(String id);
 public void activateUser(int id);
 public User getUserByEmail(String email,String password);
}

