package com.foodcoop.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.foodcoop.domain.UserRole;
import com.foodcoop.jdbc.UserRoleRowMapper;

public class UserRoleDaoImpl implements UserRoleDao {

	 @Autowired
	 DataSource dataSource;

	 public void insertData(UserRole userRole) {

	  String sql = "INSERT INTO userRole "
	    + "(idUser,idRole, valid) VALUES (?, ?, 1)";

	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	  jdbcTemplate.update(
	    sql,
	    new Object[] { userRole.getUserId(), userRole.getRoleId() });

	 }

	 @Override
	 public void deleteData(String id) {
	  String sql = "UPDATE userRole set valid = 0 where id =" + id;
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  jdbcTemplate.update(sql);
	 }

	 @Override
	 public void updateData(UserRole userRole) {

	  String sql = "UPDATE userRole set idRole = ? where id = ?";
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	  jdbcTemplate.update(
	    sql,
	    new Object[] { userRole.getRoleId() });

	 }

	 @Override
	 public UserRole getUserRole(String id) {
	  List<UserRole> userRoleList = new ArrayList<UserRole>();
	  String sql = "select * from user_role where id= " + id;
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  userRoleList = jdbcTemplate.query(sql, new UserRoleRowMapper());
	  return userRoleList.get(0);
	 }

}
