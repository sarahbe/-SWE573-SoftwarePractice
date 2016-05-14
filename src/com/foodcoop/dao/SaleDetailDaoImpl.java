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

import com.foodcoop.domain.Sale;
import com.foodcoop.domain.SaleDetail;

public class SaleDetailDaoImpl implements SaleDetailDao {
	@Autowired
	 DataSource dataSource;

	 private final RowMapper<SaleDetail> mapper = JdbcTemplateMapperFactory.newInstance().newRowMapper(SaleDetail.class);
	 private final SqlParameterSourceFactory<SaleDetail> parameterSourceFactory = JdbcTemplateMapperFactory.newInstance().newSqlParameterSourceFactory(SaleDetail.class);
	
	 
	@Override
	public void insertData(SaleDetail saleDetail) {
		  String sql = "INSERT INTO saleDetail "
				    + "( idsale, idproduct, idunit, quantity, price , valid) VALUES ( :idsale, :idproduct, :idunit, :quantity, :price , 1)";
				  NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

				  jdbcTemplate.update(
				    sql,parameterSourceFactory.newSqlParameterSource(saleDetail)
				    );
		
	}

	@Override
	public List<SaleDetail> getSaleDetailList(int idSale) {
		  List<SaleDetail> saleDetailList = new ArrayList<SaleDetail>();

		  String sql = "select * from saleDetail where idsale = " +idSale ;
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		  saleDetailList = jdbcTemplate.query(sql, mapper);
		  return saleDetailList;
	}

	@Override
	public SaleDetail getSaleDetail(String id) {
		SaleDetail saleDetail = new SaleDetail();
		  String sql = "select * from saleDetail where id= " + id;
		  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		  saleDetail = jdbcTemplate.query(sql, mapper).get(0);
		  return saleDetail;
	}

}
