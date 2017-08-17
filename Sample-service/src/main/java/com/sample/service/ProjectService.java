package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.Project;
import com.sample.repository.ProjetRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjetRepository pRepo;
	
	public void pService(Project pro){
		System.out.println("Inside pservice method");
		pRepo.addProject(pro);
	}
		
	public List<Project> getAllProjectS()
	{
		List<Project> l=pRepo.getAllProjectRepo();
	    return l;	
	}
	
	public boolean deleteS(Project p)
	{
		System.out.println("Inside Delete Method of Service"+p.getId());
		pRepo.deleteR(p);
	    return true;	
	}
	}

