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

import com.foodcoop.domain.Category;

public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	 DataSource dataSource;

	 private final RowMapper<Category> mapper = JdbcTemplateMapperFactory.newInstance().newRowMapper(Category.class);
	 private final SqlParameterSourceFactory<Category> parameterSourceFactory = JdbcTemplateMapperFactory.newInstance().newSqlParameterSourceFactory(Category.class);
	
	 
	 @Override
	 public void insertData(Category category) {

	  String sql = "INSERT INTO category "
	    + "( category) VALUES ( :category)";
	  NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

	  jdbcTemplate.update(
	    sql,parameterSourceFactory.newSqlParameterSource(category)
	    );

	 }
	 
	 @Override
	 public List<Category> getCategoryList() {
	  List<Category> categoryList = new ArrayList<Category>();

	  String sql = "select * from category";
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  categoryList = jdbcTemplate.query(sql, mapper);
	  return categoryList;
	 }
	 
	 @Override
	 public void deleteData(String id) {
	  String sql = "UPDATE category set valid = 0 where id =" + id;
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  jdbcTemplate.update(sql);

	 }


	 @Override
	 public void updateData(Category category) {
	  String sql = "UPDATE category set "+
	  "category = :category "+
	   " where id = :id";
	  NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	  jdbcTemplate.update(
			  sql,parameterSourceFactory.newSqlParameterSource(category));

	 }

	 @Override
	 public Category getCategory(String id) {
		 Category category = new Category();
	  String sql = "select * from category where id= " + id;
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  category = jdbcTemplate.query(sql, mapper).get(0);
	  return category;
	 }
}