package com.foodcoop.dao;

import java.util.List;

import com.foodcoop.domain.SaleDetail;

public interface SaleDetailDao {
	 public void insertData(SaleDetail saleDetail);
	 public List<SaleDetail> getSaleDetailList(int idSale);
	 public SaleDetail getSaleDetail(String id);
}
