package com.foodcoop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodcoop.dao.ProducerDao;
import com.foodcoop.dao.ProductDao;
import com.foodcoop.domain.CustomGenericException;
import com.foodcoop.domain.Producer;
import com.foodcoop.domain.Product;

public class ProductServiceImpl implements ProductService{

	 @Autowired
	 ProductDao productdao;

	 @Autowired
	 ProducerDao producerdao;
	 
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
	  //return productdao.getProductList();
		 List<Product> productList;
		 try{
		  productList = productdao.getProductList();  
	  }
	  catch(Exception ex)
	  {
		  throw new CustomGenericException("500",ex.toString());
	  }
	 
	  
	  for(Product product : productList ){
	    	Producer producer = producerdao.getProducer(Integer.toString(product.getIdProducer()));	
	    	product.setProducerName(producer.getProducerName());
	  }
	  
	  return productList;
	  
	 }

	 
	 @Override
	 public Product getProduct(String id) {
	  Product product = productdao.getProduct(id);	 
	  Producer producer = producerdao.getProducer(Integer.toString(product.getIdProducer()));	
  	product.setProducerName(producer.getProducerName());
	  return product;
	// return productdao.getProduct(id);
	 }

	 @Override
	 public void updateData(Product product) {
		 productdao.updateData(product);
	  
	 }
	 
}
