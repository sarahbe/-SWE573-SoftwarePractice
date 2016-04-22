package com.foodcoop.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.sfm.jdbc.spring.JdbcTemplateMapperFactory;
import org.sfm.jdbc.spring.SqlParameterSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.foodcoop.domain.UserRole;
import com.foodcoop.jdbc.UserRoleRowMapper;

public class UserRoleDaoImpl implements UserRoleDao {

	 @Autowired
	 DataSource dataSource;

	 private final RowMapper<UserRole> mapper = JdbcTemplateMapperFactory.newInstance().newRowMapper(UserRole.class);
	 private final SqlParameterSourceFactory<UserRole> parameterSourceFactory = JdbcTemplateMapperFactory.newInstance().newSqlParameterSourceFactory(UserRole.class);
	 
	 @Override
	 public void insertData(UserRole userRole) {

	  String sql = "INSERT INTO user_role "
	    + "(idUser,idRole, valid) VALUES (:iduser,:idrole, 1)";


	  NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	  jdbcTemplate.update(
			    sql,parameterSourceFactory.newSqlParameterSource(userRole)
			    );
	
	 }

	 @Override
	 public void deleteData(String id) {
	  String sql = "UPDATE user_role set valid = 0 where id =" + id;
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  jdbcTemplate.update(sql);
	 }

	 @Override
	 public void updateData(UserRole userRole) {

	  String sql = "UPDATE user_role set idRole = ? where id = ?";
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
