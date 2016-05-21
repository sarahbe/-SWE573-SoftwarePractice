package com.foodcoop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodcoop.dao.SaleDao;
import com.foodcoop.dao.SaleDetailDao;
import com.foodcoop.domain.Sale;
import com.foodcoop.domain.SaleDetail;

public class SaleServiceImpl implements SaleService {
//
//	@Autowired
//	SaleDao saledao;
//	
//	@Autowired
//	SaleDetailDao saledetaildao;
	
	private SaleDetailDao saledetaildao;
	private SaleDao saledao;
	
	@Autowired
	public SaleServiceImpl(SaleDao saledao, SaleDetailDao saledetaildao){
		this.saledao = saledao;
		this.saledetaildao = saledetaildao;
	}
	
	
	
	@Override
	public void insertData(Sale sale) {
		saledao.insertData(sale);
	}

	@Override
	public void insertDetail(List<SaleDetail> saleDetails)
	{
		for (SaleDetail item : saleDetails){
			saledetaildao.insertData(item);
		}
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
