package com.foodcoop.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductCotroller {
	   @RequestMapping(value="/products",method = RequestMethod.GET)
	    public String viewProductList(Map<String, Object> model) {
	    	
	           return "/products";

	    }
	   
	   @RequestMapping(value="/newProduct",method = RequestMethod.GET)
	    public String viewNewProduct(Map<String, Object> model) {
	    	
	           return "/newProduct";

	    }
}
