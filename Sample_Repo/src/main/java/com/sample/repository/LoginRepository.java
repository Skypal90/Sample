package com.sample.repository;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sample.model.User;
@Repository
public class LoginRepository {
	

@Autowired	
private HibernateTemplate hibernateTemplate;
	
		

	 public boolean userSignIn(User usr){
		 String email=usr.getEmail();
		 System.out.println("Inside Repository");
		 List<User> login=(List<User>) hibernateTemplate.find("from User u1 where u1.email=?" , email);
		 if(login.size()>0)
		 {
			 System.out.println();
			 return true;
		 }else
		 {
			 hibernateTemplate.save(usr);
		 }
		 
		 
		 return false;
	 }
	 

}
