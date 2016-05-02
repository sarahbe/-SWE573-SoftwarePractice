package com.foodcoop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodcoop.domain.Category;
import com.foodcoop.domain.Product;
import com.foodcoop.services.CategoryService;
import com.foodcoop.services.ProducerService;
import com.foodcoop.services.ProductService;

@Controller
public class ProductCotroller {
	 @Autowired
	 ProductService productService;
	 
	 @Autowired 
	 CategoryService categoryService;
	 
	 @Autowired 
	 ProducerService producerService;
	
	   @RequestMapping(value="/products")
	    public ModelAndView viewProductList(Map<String, Object> model) {
		   Map<String, List> map = new HashMap<String, List>();
		   List<Product> productList = productService.getProductList();
		   
		   for(Product item: productList)
		   {
			   item.getProducerName();
		   }
		   
		   map.put("productList", productList);
	           return new ModelAndView("products", "map", map);
	    }
	   
	   @RequestMapping("/newProduct")
	   public ModelAndView registerUser(@ModelAttribute Product product) {
         
	    Map<String, List> map = new HashMap<String, List>();
	    map.put("categories", categoryService.getCategoryList());
	    map.put("producers", producerService.getProducerList());
	    return new ModelAndView("newProduct", "map", map);
	   }
	   
	   @RequestMapping( "/insertProduct")
		 public String inserData(@ModelAttribute Product product) {
		  if (product != null)
			  productService.insertData(product);
		  return "redirect:/products";
		 }
}
