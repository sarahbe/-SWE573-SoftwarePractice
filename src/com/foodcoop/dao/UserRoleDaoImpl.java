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

import com.foodcoop.domain.User;
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

	  String sql = "UPDATE user_role set idRole = ?, valid = ? where id = ?";
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	  jdbcTemplate.update(
	    sql,
	    new Object[] { userRole.getRoleId(),userRole.getValid(), userRole.getId() });

	 }

	 @Override
	 public List<UserRole> getUserRoleListByUser(int idUser) {
	  List<UserRole> userRoleList = new ArrayList<UserRole>();

	  String sql = "select * from user_role where iduser = " + idUser;

	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  userRoleList = jdbcTemplate.query(sql, mapper);
	  return userRoleList;
	 }

	 
	 @Override
	 public UserRole getUserRole(String id) {
	  List<UserRole> userRoleList = new ArrayList<UserRole>();
	  String sql = "select * from user_role where id= " + id;
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  userRoleList = jdbcTemplate.query(sql, new UserRoleRowMapper());
	  return userRoleList.get(0);
	 }
	 
	 @Override
	 public UserRole getUserRole(String idUser, int idRole) {
	  List<UserRole> userRoleList = new ArrayList	<UserRole>();
	  String sql = "select * from user_role where idUser = "+idUser + " and idrole = " +idRole ;
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  userRoleList = jdbcTemplate.query(sql, mapper);
	  if (userRoleList.isEmpty())
	  {
		  return new UserRole();
	  }
	  return userRoleList.get(0);
	 }
	 

}
