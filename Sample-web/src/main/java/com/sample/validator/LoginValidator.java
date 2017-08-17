package com.sample.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.sample.model.User;


@Component
public class LoginValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User usr=(User) target;
	//ValidationUtils.rejectIfEmpty(errors, "contact", "error.contact.empty");
	//ValidationUtils.rejectIfEmpty(errors, "email", "error1","email is empty");
    //ValidationUtils.rejectIfEmpty(errors, "password","error2", "password is empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.password.empty");
		
	}

	//public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	

	

	}
