package com.foodcoop.dao;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.sql.DataSource;

import org.sfm.jdbc.spring.JdbcTemplateMapperFactory;
import org.sfm.jdbc.spring.SqlParameterSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import com.foodcoop.domain.User;
//import com.foodcoop.jdbc.UserRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.authority.GrantedAuthorityImpl;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

public class UserDaoImpl implements UserDao {

 @Autowired
 DataSource dataSource;

 private final RowMapper<User> mapper = JdbcTemplateMapperFactory.newInstance().newRowMapper(User.class);
 private final SqlParameterSourceFactory<User> parameterSourceFactory = JdbcTemplateMapperFactory.newInstance().newSqlParameterSourceFactory(User.class);
 
 @Override
 public void insertData(User user) {

  String sql = "INSERT INTO user "
    + "( registerationdate, firstname,lastname, gender, email, password, birthyear, active) VALUES (NOW(),:firstname, :lastname,:gender ,:email, :password,:birthyear,1)";

  NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);  
  jdbcTemplate.update(
    sql,parameterSourceFactory.newSqlParameterSource(user)
    );

 }

 @Override
 public List<User> getUserList() {
  List<User> userList = new ArrayList<User>();

  String sql = "select * from user";

  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
  userList = jdbcTemplate.query(sql, mapper);
  return userList;
 }

 @Override
 public void deleteData(String id) {
  String sql = "UPDATE user set active = 0 where id =" + id;
  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
  jdbcTemplate.update(sql);

 }

 @Override
 public void updateData(User user) {

  String sql = "UPDATE user set firstname = :firstname ,lastname = :lastname , gender = :gender, email = :email, password= :password, birthyear=:birthyear, active =:active where id = :id";
  NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  jdbcTemplate.update(
		  sql,parameterSourceFactory.newSqlParameterSource(user));

 }

 @Override
 public User getUser(String id) {
  List<User> userList = new ArrayList<User>();
  String sql = "select * from user where id= " + id;
  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
  userList = jdbcTemplate.query(sql, mapper);
  return userList.get(0);
 }
 
 @Override 
 public void activateUser(int userId) {

	  String sql = "UPDATE user set active = 1 where id =" + userId;
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  jdbcTemplate.update(sql);
	 }
 
 @Override
 public User getUserByEmail(String email, String password)
 {
	 User user = new User();
	 String sql = "select * from user where email = '"+ email+"' and password = "+ password+" and active =1 ";
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
   
     user = (User) jdbcTemplate.query(sql,mapper).get(0);
	 return user;
 }
 public User getUserByEmail(String email){
	 User user = new User();
	 String sql = "select * from user where active =1 and email = '"+ email + "'";
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
     user = (User) jdbcTemplate.query(sql,mapper).get(0);
	 return user; 
 }
 
 
}

