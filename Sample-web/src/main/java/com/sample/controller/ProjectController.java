package com.sample.controller;

import java.util.List;
import java.util.Map;

import javax.persistence.MapsId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.model.Project;
import com.sample.service.ProjectService;
import com.sample.validator.ProjectValidator;

@Controller
public class ProjectController {

@Autowired
private ProjectService pServ;
	
@Autowired
private ProjectValidator projectValidator;

@RequestMapping("/projectList")
public String showDetail(Map<String, Object> map,ModelMap m){
	System.out.println("Inside proController");
	map.put("Project",new Project());

    List<Project> l=pServ.getAllProjectS();
    m.addAttribute("list", l);
	
	return "projectList";
}
	
@RequestMapping(value="/PDetail", method=RequestMethod.POST)
public String addProject1(@ModelAttribute("Project") Project pro,BindingResult result,ModelMap m){
	//System.out.println(pro.getcName()+" "+pro.getStDate()+" "+pro.getEnDate()+" "+pro.getcName());	
    System.out.println("Inside Project controller");
	projectValidator.validate(pro,result);
	if(result.hasErrors())
	{
		return "projectList";
	}
    
    System.out.println("Return from validates Method");
    pServ.pService(pro);
    List<Project> l=pServ.getAllProjectS();

    
    m.addAttribute("Project",new Project());
    m.addAttribute("list", l);
    
    
    return "projectList";
	}


@RequestMapping(value="/delete",method=RequestMethod.GET)
public String delete(@ModelAttribute("project")Project p)
{
	     
	System.out.println("Inside Delete Method of Controller"+p.getId());
	pServ.deleteS(p);
	return "redirect:/projectList.do";	
}
}












