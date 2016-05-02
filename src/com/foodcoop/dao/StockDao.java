package com.foodcoop.dao;

import java.util.List;

import com.foodcoop.domain.Stock;

public interface StockDao {
	 public void insertData(Stock stock);
	 public List<Stock> getStockList();
	 public void updateData(Stock stock);
	 public Stock getStock(String id);
}
