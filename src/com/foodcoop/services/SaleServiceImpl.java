package com.foodcoop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodcoop.dao.SaleDao;
import com.foodcoop.dao.SaleDetailDao;
import com.foodcoop.domain.Product;
import com.foodcoop.domain.Sale;
import com.foodcoop.domain.SaleDetail;

public class SaleServiceImpl implements SaleService {

	@Autowired
	SaleDao saledao;
	
	@Autowired
	SaleDetailDao saledetaildao;

	@Autowired
	ProductService productService;
	
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
		
		insertData(sale);
		
		for (SaleDetail item : sale.getSaleDetail()){
			item.setIdSale(sale.getId());
		}		
		
		insertDetail(sale.getSaleDetail());		
		
	}

	private void calculateSale(Sale sale) {
		Double total = 0.0;
		for(SaleDetail detail : sale.getSaleDetail()){
			//Product product = productService.getProduct(Integer.toString(detail.getIdProduct()));			
			total += detail.getQuantity() * detail.getPrice();			
		}		
		sale.setTotal(total);
		sale.setNet(sale.getTotal() - sale.getDiscount());
	}
}
