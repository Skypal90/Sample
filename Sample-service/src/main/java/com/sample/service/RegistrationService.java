package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.User;
import com.sample.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository regiRepo;
	
	
	
	public boolean validate(User usr){
		System.out.println("inside registration service");
		regiRepo.userSignIn(usr);
		return true;
		
	}

}
