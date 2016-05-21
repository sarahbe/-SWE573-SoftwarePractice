package com.foodcoop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.foodcoop.services.UserService;


//@RequestMapping("/auth")
@Controller
public class LoginLogoutController {

	@Autowired
	UserService userService;

	@RequestMapping(
			value = "/login",
			method = RequestMethod.GET)
	public String getLoginPage(@RequestParam(value = "error",required = false) boolean error, ModelMap model) {
		if (error == true) {
			model.put("error",
					"You have entered an invalid username or password!");
		} else {
			model.put("error", "");
		}
		return "LoginForm";
	}

	@RequestMapping(
			value = "/deniedPage",
			method = RequestMethod.GET)
	public String getDeniedPage() {

		return "deniedPage";
	}

	@RequestMapping(
			value = "/logoutSuccessful",
			method = RequestMethod.GET)
	public String getLogout() {

		return "logoutSuccessful";
	}
}