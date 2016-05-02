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

import com.foodcoop.domain.Stock;

public class StockDaoImpl implements StockDao {
	@Autowired
	 DataSource dataSource;

	 private final RowMapper<Stock> mapper = JdbcTemplateMapperFactory.newInstance().newRowMapper(Stock.class);
	 private final SqlParameterSourceFactory<Stock> parameterSourceFactory = JdbcTemplateMapperFactory.newInstance().newSqlParameterSourceFactory(Stock.class);
	
	 
	 @Override
	 public void insertData(Stock stock) {

	  String sql = "INSERT INTO stock "
	    + "( stock) VALUES ( :stock)";
	  NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

	  jdbcTemplate.update(
	    sql,parameterSourceFactory.newSqlParameterSource(stock)
	    );

	 }
	 
	 @Override
	 public List<Stock> getStockList() {
	  List<Stock> stockList = new ArrayList<Stock>();

	  String sql = "select * from stock";
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  stockList = jdbcTemplate.query(sql, mapper);
	  return stockList;
	 }
	 



	 @Override
	 public void updateData(Stock stock) {
	  String sql = "UPDATE stock set "+
	  "stock = :stock "+
	   " where id = :id";
	  NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	  jdbcTemplate.update(
			  sql,parameterSourceFactory.newSqlParameterSource(stock));

	 }

	 @Override
	 public Stock getStock(String id) {
		 Stock stock = new Stock();
	  String sql = "select * from stock where id= " + id;
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  stock = jdbcTemplate.query(sql, mapper).get(0);
	  return stock;
	 }
}
