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

import com.foodcoop.domain.Unit;

public class UnitDaoImpl implements UnitDao{
	@Autowired
	 DataSource dataSource;

	 private final RowMapper<Unit> mapper = JdbcTemplateMapperFactory.newInstance().newRowMapper(Unit.class);
	 private final SqlParameterSourceFactory<Unit> parameterSourceFactory = JdbcTemplateMapperFactory.newInstance().newSqlParameterSourceFactory(Unit.class);
	
	 
	 @Override
	 public void insertData(Unit unit) {

	  String sql = "INSERT INTO unit "
	    + "(unit) VALUES (:unit)";
	  NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

	  jdbcTemplate.update(
	    sql,parameterSourceFactory.newSqlParameterSource(unit)
	    );

	 }
	 
	 @Override
	 public List<Unit> getUnitList() {
	  List<Unit> unitList = new ArrayList<Unit>();

	  String sql = "select * from unit";
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  unitList = jdbcTemplate.query(sql, mapper);
	  return unitList;
	 }
	 
	 @Override
	 public void deleteData(String id) {
	  String sql = "UPDATE unit set valid = 0 where id =" + id;
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  jdbcTemplate.update(sql);

	 }


	 @Override
	 public void updateData(Unit unit) {
	  String sql = "UPDATE unit set "+
	  "unit = :unit "+
	   " where id = :id";
	  NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	  jdbcTemplate.update(
			  sql,parameterSourceFactory.newSqlParameterSource(unit));

	 }

	 @Override
	 public Unit getUnit(String id) {
		 Unit unit = new Unit();
	  String sql = "select * from unit where id= " + id;
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  unit = jdbcTemplate.query(sql, mapper).get(0);
	  return unit;
	 }
}
