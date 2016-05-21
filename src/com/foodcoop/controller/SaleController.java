package com.foodcoop.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.foodcoop.domain.Product;
import com.foodcoop.domain.Sale;
import com.foodcoop.domain.SaleDetail;
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
	 
	 

		@RequestMapping(value = "/saveInvoice",method = RequestMethod.POST)
		public String inserData(@ModelAttribute("sale") Sale sale) {
			
			sale.setSaleDate(new Date());			
			
			saleService.saveSale(sale);
			
//			if (product != null) {
//					Sale sale = new Sale();
//					sale.setTotal(10);
//					List<SaleDetail> saleDetailsList = new ArrayList<SaleDetail>();
//					SaleDetail detail = new SaleDetail();
//					saleService.insertData(sale);
//					detail.setQuantity(1);
//					//detail.setIdProduct(product.getId());
//					detail.setIdSale(sale.getId());
//					saleDetailsList.add(detail);,
//					saleService.insertDetail(saleDetailsList);
//			
//			}

			return "redirect:/sales";

		}
}
