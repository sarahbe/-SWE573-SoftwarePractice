package com.foodcoop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodcoop.dao.ProductDao;
import com.foodcoop.domain.Product;

public class ProductServiceImpl implements ProductService{

	 @Autowired
	 ProductDao productdao;

	 @Override
	 public void insertData(Product product) {
		 productdao.insertData(product);
	 }

	 @Override
	 public void deleteData(String id) {
		 productdao.deleteData(id);
	  
	 }

	 @Override
	 public List<Product> getProductList() {
	  return productdao.getProductList();
	 }

	 
	 @Override
	 public Product getProduct(String id) {
	  return productdao.getProduct(id);
	 }

	 @Override
	 public void updateData(Product product) {
		 productdao.updateData(product);
	  
	 }
	 
}
