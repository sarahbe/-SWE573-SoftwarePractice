package com.foodcoop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.foodcoop.domain.Product;
import com.foodcoop.domain.Stock;
import com.foodcoop.services.ProductService;
import com.foodcoop.services.StockService;
import com.foodcoop.services.UnitService;

@Controller
public class StockController {
	@Autowired
	ProductService productService;
	@Autowired
	UnitService unitService; 
	@Autowired
	StockService stockService; 
	
	 @RequestMapping("/stock")
		public ModelAndView viewProductList(Map<String, Object> model) {
			Map<String, List> map = new HashMap<String, List>();
		    List<Product> productList = productService.getProductList(); 
			for (Product item : productList)
			{
				
			}
			List<Stock> stockList = stockService.getStockList();

			map.put("unitList", unitService.getUnitList());
			map.put("stockList", stockList);
			return new ModelAndView("stock", "map", map);
		}
	
}