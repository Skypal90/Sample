package com.sample.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.sample.model.Project;
@Component
public class ProjectValidator {

	
public Boolean sopports(Class<?> clazz)
{
return Project.class.isAssignableFrom(clazz);	
}

public void validate(Object target,Errors errors)
{
	System.out.println("Inside Validates Menthods");
	Project pro=(Project)target;
	ValidationUtils.rejectIfEmpty(errors,"pName","error.pName.empty");
	ValidationUtils.rejectIfEmpty(errors,"stDate","error.stDate.empty");
	ValidationUtils.rejectIfEmpty(errors,"enDate","error.enDate.empty");
	ValidationUtils.rejectIfEmpty(errors,"cName","error.cName.empty");
}

}
