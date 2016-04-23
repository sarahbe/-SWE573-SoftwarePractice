package com.foodcoop.services;

import java.util.List;

import com.foodcoop.domain.Product;

public interface ProductService {
	 public void insertData(Product product);
	 public void updateData(Product product);
	 public List<Product> getProductList();
	 public void deleteData(String id);
	 public Product getProduct(String id);
}
