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
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.foodcoop.domain.Sale;
import com.foodcoop.domain.Stock;

public class SaleDaoImpl implements SaleDao{
	@Autowired
	 DataSource dataSource;

	 private final RowMapper<Sale> mapper = JdbcTemplateMapperFactory.newInstance().newRowMapper(Sale.class);
	 private final SqlParameterSourceFactory<Sale> parameterSourceFactory = JdbcTemplateMapperFactory.newInstance().newSqlParameterSourceFactory(Sale.class);
	
	 
	 @Override
	 public void insertData(Sale sale) {

	  KeyHolder keyHolder = new GeneratedKeyHolder();
		 
	  String sql = "INSERT INTO sale "
	    + "( idseller, idmember, saledate, total, discount, net,valid) VALUES ( :idseller, :idmember, NOW(), :total, :discount, :net,1)";
	  NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

	  jdbcTemplate.update(
	    sql,parameterSourceFactory.newSqlParameterSource(sale), keyHolder
	    );

	  sale.setId(keyHolder.getKey().intValue());
	  
	 }
	 
	 @Override
	 public List<Sale> getSaleList() {
	  List<Sale> saleList = new ArrayList<Sale>();

	  String sql = "select * from sale";
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  saleList = jdbcTemplate.query(sql, mapper);
	  return saleList;
	 }
	 

	 @Override
	 public Sale getSale(String id) {
		 Sale sale = new Sale();
	  String sql = "select * from sale where id= " + id;
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  sale = jdbcTemplate.query(sql, mapper).get(0);
	  return sale;
	 }
}
