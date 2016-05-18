package com.foodcoop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.foodcoop.domain.User;
import com.foodcoop.domain.UserRole;
import com.foodcoop.services.UserRoleService;
import com.foodcoop.services.UserService;

@Controller
public class HomePageController {

 @Autowired
 UserService userService;
 
 @Autowired 
 UserRoleService userRoleService;

 //The @RequestMapping annotation on the methods use the value attribute to map the method to a path.
 //The beginning of the path is given by context:component-scan
 @RequestMapping("/register")
 public ModelAndView registerUser(@ModelAttribute User user) {

  List<String> genderList = new ArrayList<String>();
  genderList.add("male");
  genderList.add("female");

  Map<String, List> map = new HashMap<String, List>();
  map.put("genderList", genderList);
  return new ModelAndView("register", "map", map);
 }
 
 @RequestMapping("/")
 public ModelAndView index() {

  
  return new ModelAndView("index");
 }
 
 @RequestMapping( "/insert")
 public String inserData(@ModelAttribute User user) {
  if (user != null){
   userService.insertData(user);

  }
  return "redirect:/";
 }

 @RequestMapping("/getList")
 public ModelAndView getUserLIst() {
  List<User> userList = userService.getUserList();
  return new ModelAndView("userList", "userList", userList);
 }

 @RequestMapping("/edit")
 public ModelAndView editUser(@RequestParam String id,
   @ModelAttribute User user) {

  user = userService.getUser(id);

  List<String> genderList = new ArrayList<String>();
  genderList.add("male");
  genderList.add("female");

  Map<String, Object> map = new HashMap<String, Object>();
  map.put("genderList", genderList);
  map.put("user", user);

  return new ModelAndView("edit", "map", map);

 }

 @RequestMapping("/update")
 public String updateUser(@ModelAttribute User user) {
  userService.updateData(user);
  return "redirect:/getList";

 }

 @RequestMapping("/delete")
 public String deleteUser(@RequestParam String id) {
  System.out.println("id = " + id);
  userService.deleteData(id);
  return "redirect:/getList";
 }
 
 @RequestMapping("/approve")
 public String approveUser(@RequestParam String id,@RequestParam boolean active) {	 
  userService.grantUserRole(id,1, active);
  return "redirect:/getList";
 }
 
 @RequestMapping("/seller")
 public String setSeller(@RequestParam String id,@RequestParam boolean active) {
 userService.grantUserRole(id, 3,active);
  return "redirect:/getList";
 }
 
 @RequestMapping("/stocker")
 public String setStocker(@RequestParam String id,@RequestParam boolean active) {
	 userService.grantUserRole(id, 4, active);
  return "redirect:/getList";
 }
 
 @RequestMapping("/admin")
 public String setAdmin(@RequestParam String id,@RequestParam boolean active) {
	 userService.grantUserRole(id, 2,active);
  return "redirect:/getList";
 }
 
}
