package com.foodcoop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.foodcoop.domain.Unit;
import com.foodcoop.services.UnitService;

@Controller
public class UnitController {
	 @Autowired
	 UnitService unitService;
	 
	 @RequestMapping("/unit")
	 public ModelAndView showUnit(@ModelAttribute Unit unit) {
	
	  return new ModelAndView("unit");
	 }
	 
	 @RequestMapping( "/insertUnit")
	 public String inserData(@ModelAttribute Unit unit) {
	  if (unit != null)
		  unitService.insertData(unit);
	  return "redirect:/newProduct";
	 }
}
