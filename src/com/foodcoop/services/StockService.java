package com.foodcoop.services;

import java.util.List;

import com.foodcoop.domain.Stock;

public interface StockService {
	 public void insertData(Stock stock);
	 public void updateData(Stock stock);
	 public List<Stock> getStockList();
	 public Stock getStock(String id);
}
