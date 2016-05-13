package com.foodcoop.dao;

import java.util.List;

import com.foodcoop.domain.Sale;

public interface SaleDao {
	 public void insertData(Sale sale);
	 public List<Sale> getSaleList();
	 public Sale getSale(String id);
}
