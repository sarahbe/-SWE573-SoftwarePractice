package com.foodcoop.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.foodcoop.domain.UserRole;

public class UserRoleRowMapper implements RowMapper<UserRole>{
	 @Override
	 public UserRole mapRow(ResultSet resultSet, int line) throws SQLException {
		 UserRole userRole = new UserRole();  
		    
		 userRole.setId(resultSet.getInt(1));  
		 userRole.setUserId(resultSet.getInt(2)); 
		 userRole.setRoleId(resultSet.getInt(3)); 
		  return userRole;  
	 }
}
