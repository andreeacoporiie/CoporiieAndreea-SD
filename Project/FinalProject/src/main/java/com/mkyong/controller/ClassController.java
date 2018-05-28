package com.mkyong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mkyong.entity.Class;
import com.mkyong.filter.GroupFilterSpecification;
import com.mkyong.service.ClassService;

@Controller
public class ClassController {
    
    @Autowired
    ClassService service;
    
    @RequestMapping(value = "/class", method = RequestMethod.GET)
    public String cls(Model model) {
    	List<Class> classes = service.findAll();
    	classes = service.filter(classes, new GroupFilterSpecification(30433));
    	model.addAttribute("classes",classes);
        return "/class"; 
    }
}
