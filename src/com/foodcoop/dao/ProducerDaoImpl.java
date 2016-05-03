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

import com.foodcoop.domain.Producer;

public class ProducerDaoImpl implements ProducerDao{
	@Autowired
	 DataSource dataSource;

	 private final RowMapper<Producer> mapper = JdbcTemplateMapperFactory.newInstance().newRowMapper(Producer.class);
	 private final SqlParameterSourceFactory<Producer> parameterSourceFactory = JdbcTemplateMapperFactory.newInstance().newSqlParameterSourceFactory(Producer.class);
	
	 
	 @Override
	 public void insertData(Producer producer) {

	  String sql = "INSERT INTO producer "
	    + "( producerName, description , image) VALUES ( :producerName, :description, :image)";
	  NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

	  jdbcTemplate.update(
	    sql,parameterSourceFactory.newSqlParameterSource(producer)
	    );

	 }
	 
	 @Override
	 public List<Producer> getProducerList() {
	  List<Producer> producerList = new ArrayList<Producer>();

	  String sql = "select * from producer";
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  producerList = jdbcTemplate.query(sql, mapper);
	  return producerList;
	 }

	 @Override
	 public void deleteData(String id) {
	  String sql = "UPDATE producer set valid = 0 where id =" + id;
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  jdbcTemplate.update(sql);

	 }

	 @Override
	 public void updateData(Producer producer) {
	  String sql = "UPDATE producer set "+
	  "producerName = :producerName ,description = :description "+
	   " where id = :id";
	  NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	  jdbcTemplate.update(
			  sql,parameterSourceFactory.newSqlParameterSource(producer));

	 }

	 @Override
	 public Producer getProducer(String id) {
		 Producer producer = new Producer();
	  String sql = "select * from producer where id= " + id;
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  producer = jdbcTemplate.query(sql, mapper).get(0);
	  return producer;
	 }
}
