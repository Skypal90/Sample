package com.sample.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sample.model.User;

@Repository
public class RegistrationRepository {
	

@Autowired	
private HibernateTemplate hibernateTemplate;
	
public boolean userSignIn(User usr){
	 String email=usr.getEmail();
	 System.out.println("Inside Repository");
	 List<User> registration=(List<User>)hibernateTemplate.find("from User u1 where u1.email=? ", email);
	 
	 
	 
	 if(registration.size()>0)
	 {
		  return true;
	 }else
	 {
		 hibernateTemplate.save(usr);
	 }
	 
	 
	 return false;
}
	
	 /*public User userSave(User user){
		 
		 System.out.println("Inside Repository save");
		 System.out.println(user.getEmail());
		 System.out.println(user.getPassword());
		 System.out.println(hibernateTemplate);
		 hibernateTemplate.save(user);
		 return user;
	 }

*/	

}
