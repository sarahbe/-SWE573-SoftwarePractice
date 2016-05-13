package com.foodcoop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.foodcoop.domain.Sale;

@Controller
public class SaleController {

	 @RequestMapping("/sales")
	 public ModelAndView registerUser(@ModelAttribute Sale sale) {
	
	  return new ModelAndView("sales");
	 }
}
