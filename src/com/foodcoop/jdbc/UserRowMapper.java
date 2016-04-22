package com.foodcoop.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.foodcoop.domain.User;
///RowMapper is a useful interface provided by spring JDBC,
//it can be used to map rows in a resultset on per row basis. 

public class UserRowMapper implements RowMapper<User> {

 @Override
 public User mapRow(ResultSet resultSet, int line) throws SQLException {
	 User user = new User();  
	    
	  user.setUserId(resultSet.getInt(1));  
	  user.setFirstName(resultSet.getString(2));  
	  user.setLastName(resultSet.getString(3));  
	  user.setGender(resultSet.getString(4));  
	  user.setEmail(resultSet.getString(5));  
	  user.setPassword(resultSet.getString(6));
	  return user;  
 }

}

