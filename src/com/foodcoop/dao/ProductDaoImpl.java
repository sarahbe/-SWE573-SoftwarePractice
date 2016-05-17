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

import com.foodcoop.domain.Product;

public class ProductDaoImpl implements ProductDao{
	@Autowired
	 DataSource dataSource;

	 private final RowMapper<Product> mapper = JdbcTemplateMapperFactory.newInstance().newRowMapper(Product.class);
	 private final SqlParameterSourceFactory<Product> parameterSourceFactory = JdbcTemplateMapperFactory.newInstance().newSqlParameterSourceFactory(Product.class);
	 
	 @Override
	 public void insertData(Product product) {

	  String sql = "INSERT INTO product "
	    + "( productName, description,idcategory, rate, idproducer, origin,price, idunit, image) VALUES ( :productName, :description,:idcategory, :rate, :idproducer, :origin,:price,:idunit, :image)";
	  NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

	  jdbcTemplate.update(
	    sql,parameterSourceFactory.newSqlParameterSource(product)
	    );

	 }
	 @Override
	 public List<Product> getProductList() {
	  List<Product> productList = new ArrayList<Product>();

	  String sql = "select * from product";
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  productList = jdbcTemplate.query(sql, mapper);
	  return productList;
	 }

	 @Override
	 public void deleteData(String id) {
	  String sql = "UPDATE product set valid = 0 where id =" + id;
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  jdbcTemplate.update(sql);

	 }

	 @Override
	 public void updateData(Product product) {
	  String sql = "UPDATE product set "+
	  "productName = :productName ,description = :description , idcategory = :idcategory "+
	   ", rate = :rate, idproducer= :idproducer, origin=:origin where id = :id";
	  NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	  jdbcTemplate.update(
			  sql,parameterSourceFactory.newSqlParameterSource(product));

	 }

	 @Override
	 public Product getProduct(String id) {
	  Product product = new Product();
	  String sql = "select * from product where id= " + id;
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  product = jdbcTemplate.query(sql, mapper).get(0);
	  return product;
	 }
}
