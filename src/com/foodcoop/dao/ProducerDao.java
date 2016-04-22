package com.foodcoop.dao;

import java.util.List;

import com.foodcoop.domain.Producer;

public interface ProducerDao {
	 public void insertData(Producer producer);
	 public List<Producer> getProducerList();
	 public void updateData(Producer producer);
	 public void deleteData(String id);
	 public Producer getProducer(String id);
}
