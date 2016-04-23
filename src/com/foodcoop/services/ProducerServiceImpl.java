package com.foodcoop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodcoop.dao.ProducerDao;
import com.foodcoop.domain.Producer;

public class ProducerServiceImpl implements ProducerService {


	 @Autowired
	 ProducerDao producerdao;

	 @Override
	 public void insertData(Producer category) {
		 producerdao.insertData(category);
	 }

	 @Override
	 public void deleteData(String id) {
		 producerdao.deleteData(id);
	  
	 }

	 @Override
	 public List<Producer> getProducerList() {
	  return producerdao.getProducerList();
	 }

	 
	 @Override
	 public Producer getProducer(String id) {
	  return producerdao.getProducer(id);
	 }

	 @Override
	 public void updateData(Producer producer) {
		 producerdao.updateData(producer);
	  
	 }
	 
}
