package com.sample.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.model.User;
import com.sample.service.LoginService;
import com.sample.validator.LoginValidator;

@Controller
public class LoginController {

@Autowired
private LoginService loginservice;

@Autowired
private LoginValidator loginvalidator;

@RequestMapping("/login")
public String showLogin(Map<String,User> map) {
	System.out.println("Inside Controller");
	map.put("User",new User());
	return "login";
}
@RequestMapping(value="/Login", method=RequestMethod.POST)
public String checkLogin(@ModelAttribute("User") User usr, BindingResult result){
//	System.out.println(usr.getEmail());
	//System.out.println(usr.getPassword());
	
	
	loginvalidator.validate(usr,result);
	
	if(result.hasErrors())
	{
	return "login";
	}
	System.out.println("login done");
	loginservice.validateUser(usr);
return "login";

}

}





