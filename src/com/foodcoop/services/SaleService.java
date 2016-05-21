package com.foodcoop.services;

import java.util.List;

import com.foodcoop.domain.Sale;
import com.foodcoop.domain.SaleDetail;

public interface SaleService {
	 public void insertData(Sale sale);
	 public void insertDetail(List<SaleDetail> saleDetails);
	 public List<Sale> getSaleList();
	 public Sale getSale(String id);
	public void saveSale(Sale sale);
}
