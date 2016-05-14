package com.foodcoop.services;

import java.util.List;

import com.foodcoop.domain.Sale;

public interface SaleService {
	 public void insertData(Sale sale);
	 public List<Sale> getSaleList();
	 public Sale getSale(String id);
}
