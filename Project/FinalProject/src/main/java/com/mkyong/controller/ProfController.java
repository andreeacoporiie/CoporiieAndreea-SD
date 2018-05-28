package com.mkyong.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mkyong.entity.Professor;
import com.mkyong.service.ProfService;

@Controller
public class ProfController {
	
	@Autowired
	ProfService service;
	
	@RequestMapping(value = "/profs", method = RequestMethod.GET)
	public String profs(Model model) {
		List<Professor> professors = service.findAll();
	    model.addAttribute("professors", professors);
	    return "/profs"; 
	}
	
}
