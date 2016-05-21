package com.foodcoop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodcoop.dao.SaleDao;
import com.foodcoop.dao.SaleDetailDao;
import com.foodcoop.domain.Sale;
import com.foodcoop.domain.SaleDetail;

public class SaleServiceImpl implements SaleService {

	@Autowired
	SaleDao saledao;
	
	@Autowired
	SaleDetailDao saledetaildao;

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

	
	@Override
	public void saveSale(Sale sale) {
		calculateSale(sale);
		
		
		
	}

	private void calculateSale(Sale sale) {
		Double total = 0.0;
		for(SaleDetail detail : sale.getSaleDetail()){
			total += detail.getQuantity() * detail.getPrice();			
		}		
		sale.setTotal(total);
		sale.setNet(sale.getTotal() - sale.getDiscount());
	}
}
