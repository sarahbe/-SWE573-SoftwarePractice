package com.foodcoop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodcoop.dao.ProductDao;
import com.foodcoop.dao.StockDao;
import com.foodcoop.domain.Product;
import com.foodcoop.domain.Stock;

public class StockServiceImpl implements StockService {

	 @Autowired
	 StockDao stockdao;

	 @Autowired
	 ProductDao productdao;
	 
	 
	 @Override
	 public void insertData(Stock stock) {
		 stockdao.insertData(stock);
	 }


	 @Override
	 public List<Stock> getStockList() {
	  List<Stock> stockList = stockdao.getStockList(); 
	  for (Stock stock : stockList){
		  Product product = productdao.getProduct(Integer.toString(stock.getIdProduct()));
		  stock.setProduct(product);
	  }		  
		 
	  return stockList;
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
