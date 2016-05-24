package com.foodcoop.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.foodcoop.domain.Product;
import com.foodcoop.domain.Sale;
import com.foodcoop.services.ProductService;
import com.foodcoop.services.SaleService;

@Controller
public class SaleController {

	@Autowired
	ProductService productService;

	@Autowired
	SaleService saleService;

	@RequestMapping("/sales")
	public ModelAndView viewPage(@ModelAttribute Sale sale) {
		Map<String, List> map = new HashMap<String, List>();
		List<Product> productList = productService.getProductList();
		for (Product item : productList) {
			item.getProducerName();
		}
		map.put("productList", productList);
		return new ModelAndView("sales", "map", map);
	}

	@RequestMapping(
			value = "/saveInvoice",
			method = RequestMethod.POST)
	public String inserData(@ModelAttribute("sale") Sale sale) {
		sale.setSaleDate(new Date());
		saleService.saveSale(sale);	
		return "redirect:/sales";

	}
	
	 @RequestMapping("/listSales")
	 public ModelAndView ListSales() {
			List<Sale> saleList = saleService.getSaleList();
	  return new ModelAndView("listSales", "saleList", saleList);
	 }
}
