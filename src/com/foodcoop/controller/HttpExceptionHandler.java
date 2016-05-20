package com.foodcoop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HttpExceptionHandler {

	@RequestMapping("/404")
	public ModelAndView exception() {
		return new ModelAndView("404");
	}
}
