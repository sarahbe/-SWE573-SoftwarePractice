package com.foodcoop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodcoop.dao.SaleDao;
import com.foodcoop.domain.Sale;

public class SaleServiceImpl implements SaleService {

	@Autowired
	SaleDao saledao;


	@Override
	public void insertData(Sale sale) {
		saledao.insertData(sale);
	}

	@Override
	public List<Sale> getSaleList() {
		return saledao.getSaleList();
	}

	@Override
	public Sale getSale(String id) {
		return saledao.getSale(id);
	}

}
