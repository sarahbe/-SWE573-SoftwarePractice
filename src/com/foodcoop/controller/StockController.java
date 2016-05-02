package com.foodcoop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.foodcoop.domain.Stock;
import com.foodcoop.services.StockService;

@Controller
public class StockController {
	 @Autowired
	 StockService stockService;
	 
	 @RequestMapping("/stock")
	 public ModelAndView registerUser(@ModelAttribute Stock stock) {
	
	  return new ModelAndView("stock");
	 }
	
}