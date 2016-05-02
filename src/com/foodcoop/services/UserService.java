package com.foodcoop.services;

import java.util.List;
import com.foodcoop.domain.User;

public interface UserService {

 public void insertData(User user);
 public List<User> getUserList();
 public void deleteData(String id);
 public User getUser(String id);
 public void updateData(User user);
 public void grantUserRole(String id, int idRole, boolean active);
 public User getUserByEmail(String email,String password);

}

