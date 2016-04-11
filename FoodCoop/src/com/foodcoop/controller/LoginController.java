package com.foodcoop.controller;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.foodcoop.domain.*;
import com.foodcoop.services.UserService;

@Controller
//@RequestMapping("login")
public class LoginController {
	@Autowired
	UserService userService;
	/*
	 @RequestMapping("/login")
	 public ModelAndView login() {
	  
	  return new ModelAndView("loginform");
	 }
/*
    @RequestMapping(value = "/LoginForm", method = RequestMethod.GET)
    public String viewLogin(Map<String, Object> model) {
        User user = new User();
        model.put("userForm", user);
        return "LoginForm";
    }
 
    @RequestMapping(value = "/loginform", method = RequestMethod.POST)
    public String doLogin(@Valid @ModelAttribute("userForm") User userForm,
            BindingResult result, Map<String, Object> model) {
        if (result.hasErrors()) {
            return "LoginForm";
        }
 
        return "index";
    }
    */
	    @RequestMapping(value="/login",method = RequestMethod.GET)
	    public String viewLogin(Map<String, Object> model) {
	    	   User user = new User();
	           model.put("userForm", user);
	           return "LoginForm";

	    }
	 
	    @RequestMapping(value="/login", method = RequestMethod.POST)
	    public String doLogin(@Valid @ModelAttribute("userForm") User userForm,
	            BindingResult result, Map<String, Object> model) {
	 
	        if (result.hasErrors()) {
	            return "LoginForm";
	        }
	 
	        return "redirect:/index";
	    
	}
	
}
