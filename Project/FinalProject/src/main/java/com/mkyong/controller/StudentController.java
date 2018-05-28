package com.mkyong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mkyong.entity.Student;
import com.mkyong.filter.GroupFilterSpecification;
import com.mkyong.service.ClassService;
import com.mkyong.service.StudentService;
import com.mkyong.entity.Class;

@Controller
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@Autowired
	ClassService classService;
	
	
	@RequestMapping(value = "/stud", method = RequestMethod.GET)
	public String stud(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Student s = service.findByUser(auth.getName());
		List<Student> students = service.filterByGr(s.getGroup().getIdGroup());
	    model.addAttribute("students", students);
	    return "/stud"; 
	}
	
    @GetMapping("/schedule")
    public String schedule(Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	Student s = service.findByUser(auth.getName());
    	if (s != null)
    	{
    		// filter classes for user's group
    		List<Class> classes = classService.filter(classService.findAll(), new GroupFilterSpecification(s.getGroup().getIdGroup()));
    		model.addAttribute("classes", classes);
    	}
        return "/schedule";
    }
	
}





