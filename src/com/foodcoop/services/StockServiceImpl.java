package com.foodcoop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodcoop.dao.StockDao;
import com.foodcoop.domain.Stock;

public class StockServiceImpl implements StockService {

	 @Autowired
	 StockDao stockdao;

	 @Override
	 public void insertData(Stock stock) {
		 stockdao.insertData(stock);
	 }


	 @Override
	 public List<Stock> getStockList() {
	  return stockdao.getStockList();
	 }

	 
	 @Override
	 public Stock getStock(String id) {
	  return stockdao.getStock(id);
	 }

	 @Override
	 public void updateData(Stock stock) {
		 stockdao.updateData(stock);
	  
	 }
}
