package com.sample.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.sample.model.User;
import com.sample.service.RegistrationService;
@Component
public class RegisterValidation {
	
	@Autowired
	private RegistrationService registrationService;
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User usr=(User) target;
	//ValidationUtils.rejectIfEmpty(errors, "id", "error.contact.empty");
	ValidationUtils.rejectIfEmpty(errors, "firstName","error.firstname.empty");
    ValidationUtils.rejectIfEmpty(errors, "lastName","error.lastname.empty");
    ValidationUtils.rejectIfEmpty(errors, "email", "error.email.empty");
	ValidationUtils.rejectIfEmpty(errors, "password", "error.password.empty");
	ValidationUtils.rejectIfEmpty(errors, "mobNo", "error.mobNo.empty");
 
	if(!errors.hasErrors()){
		
	if(usr.getFirstName().length()>15){
		errors.rejectValue("firstname", "error.firstname.length");
	}
	if(usr.getLastName().length()>15){
		errors.rejectValue("lastname", "error.lastname.length");
	}
	
	
	if (usr.getPassword().length()>15){
		errors.rejectValue("password","error.password.length");
	}

	if (usr.getMobNo().length()!=10)  {
			errors.rejectValue("mobNo", "error.mobNo.length");
	 	}else
	 		{
	 		try{
	 			Long.parseLong(usr.getMobNo());
				
	 		 	}
	
	 			catch (Exception e) {
	 				errors.rejectValue("mobNo","error.mobNo.formate");
	 				}
	
	 		}
	
	if(usr.getEmail().contains("@") && usr.getEmail().contains(".") && usr.getEmail().endsWith(".com"))
	{
		String email=usr.getEmail();
		email.replace('.','@');
		String[] str=email.split("@");
		for(String str1:str)
		{
			if(str1.length()==0)
			{
				errors.rejectValue("email", "error.email.format");
				break;
			}
		}
	}
	else
	{
		errors.rejectValue("email","error.email.format");
		
	}
	}
	if(!errors.hasErrors()){
		
	if(registrationService.validate(usr)){
		errors.rejectValue("email","error.email.exist");
	}
	}
	 	}
	
	
	

  }
