package com.sample.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.model.User;
import com.sample.service.RegistrationService;
import com.sample.validator.RegisterValidation;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationService regiServ; 
	
	@Autowired
	private RegisterValidation regiValidate;
	
	@RequestMapping(value="/Registration" , method=RequestMethod.GET)
	public String showLogin(Map<String,User> map)
	  {
		System.out.println("Inside Controller");
		map.put("User",new User());
		return "registration";
	}
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String checkLogin(@ModelAttribute("User") User usr , BindingResult result ){
		System.out.println("Register Validation");
	//	System.out.println(usr.getFirstName()+" "+usr.getLastName()+" "+usr.getEmail()+" "+usr.getPassword()+" "+usr.getMobNo());
	//	regiServ.validateUser(usr);
		regiValidate.validate(usr, result);
		
		if(result.hasErrors())
				return "registration";
		
		System.out.println("Registration done");
		regiServ.validate(usr);
		
		
		return "registration";
	}

}
