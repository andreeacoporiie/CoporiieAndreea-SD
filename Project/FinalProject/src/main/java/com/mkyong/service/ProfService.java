package com.mkyong.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mkyong.entity.Professor;
import com.mkyong.repository.RepoFactory;

@Component
public class ProfService {
	
	@Autowired
	RepoFactory factory;
	
	public List<Professor> findAll()
	{
		List<Professor> list = new ArrayList<>();
		factory.getRepository("prof").findAll().forEach(e -> list.add((Professor)e));
		return list;
	}
}
