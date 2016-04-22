package com.foodcoop.dao;

import java.util.List;

import com.foodcoop.domain.Product;

public interface ProductDao {
	 public void insertData(Product product);
	 public List<Product> getProductList();
	 public void updateData(Product product);
	 public void deleteData(String id);
	 public Product getProduct(String id);
}
