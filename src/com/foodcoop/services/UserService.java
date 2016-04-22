package com.foodcoop.services;

import java.util.List;
import com.foodcoop.domain.User;

public interface UserService {

 public void insertData(User user);
 public List<User> getUserList();
 public void deleteData(String id);
 public User getUser(String id);
 public void updateData(User user);
 public void approveUser(String id);
 public User getUserByEmail(String email,String password);

}

