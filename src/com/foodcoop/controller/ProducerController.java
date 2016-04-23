package com.foodcoop.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodcoop.domain.Producer;
import com.foodcoop.services.ProducerService;

@Controller
public class ProducerController {
	@Autowired
	ProducerService producerService;
	
	  @RequestMapping(value="/producers",method = RequestMethod.GET)
	    public String viewProductList(Map<String, Object> model) {
	           return "/producers";
	    }
	   
	   @RequestMapping("/newProducer")
	   public ModelAndView newProducer(@ModelAttribute Producer producer) {
       
	    return new ModelAndView("newProducer");
	   }
	   
	   @RequestMapping( "/insertProducer")
		 public String inserData(@ModelAttribute Producer producer) {
		  if (producer != null)
			  producerService.insertData(producer);
		  return "redirect:/producers";
		 }
}
