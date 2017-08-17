package com.sample.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sample.model.Project;

@Repository
public class ProjetRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public String addProject(Project pro){
	   System.out.println(pro.getcName()+" "+pro.getStDate()+" "+pro.getEnDate()+" "+pro.getcName());
		 hibernateTemplate.save(pro);
	 	 		
		 return "a";
	   }

    public List<Project> getAllProjectRepo(){
		
		System.out.println("Project detail");
		List<Project> l=(List<Project>)hibernateTemplate.find("from Project");
		return l;
    	}

/*  public boolean deleteR(Project p)
  {
	   System.out.println("Inside Delete Method of Repository"+p.getId());
	   hibernateTemplate.delete(hibernateTemplate.get(Project.class,p.getId())); 
    
	   return true;
  }
*/	
    public boolean deleteR(Project p)
    {
   	 System.out.println("Inside Delete Method of Repository"+p.getId());
   	     if(p!=null)
   	     {
   	    	   System.out.println("delete method execute");
   	  
   	    	   List<Project> list=(List<Project>) hibernateTemplate.find("from Project where id=?",p.getId());
   	    	     if(list!=null)
   	    	     {
   	    	    	 System.out.println("list");
   	    	    	 SessionFactory sf=hibernateTemplate.getSessionFactory();
   	     	    	Session s =sf.openSession();
   	     	    	Transaction tx=s.beginTransaction();
   	     	    	s.delete(p);
   	     	    	tx.commit();
   	    	     }
   	    	boolean b= hibernateTemplate.contains(p);
   	    	   System.out.println(b);
   	     }
   	 
   	 return true;
      }
	
	
			
}
