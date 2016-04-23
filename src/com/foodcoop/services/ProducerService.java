package com.foodcoop.services;

import java.util.List;

import com.foodcoop.domain.Producer;

public interface ProducerService {
	 public void insertData(Producer producer);
	 public void updateData(Producer producer);
	 public List<Producer> getProducerList();
	 public void deleteData(String id);
	 public Producer getProducer(String id);
}
