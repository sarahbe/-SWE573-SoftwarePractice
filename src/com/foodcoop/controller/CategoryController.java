package com.foodcoop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView; 

import com.foodcoop.domain.Category;
import com.foodcoop.services.CategoryService;

@Controller
public class CategoryController {
	 @Autowired
	 CategoryService categoryService;
	 
	 @RequestMapping("/category")
	 public ModelAndView registerUser(@ModelAttribute Category category) {
	
	  return new ModelAndView("category");
	 }
	 
	 @RequestMapping( "/insertCategory")
	 public String inserData(@ModelAttribute Category category) {
	  if (category != null)
		  categoryService.insertData(category);
	  return "redirect:/newProduct";
	 }
}
