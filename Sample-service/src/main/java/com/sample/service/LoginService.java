package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.User;

import com.sample.repository.LoginRepository;
@Service
public class LoginService {
	
@Autowired
private LoginRepository loginrepository;

public User validateUser(User usr){
	System.out.println("inside  login service");
	loginrepository.userSignIn(usr);
	return usr;
	

}
}
