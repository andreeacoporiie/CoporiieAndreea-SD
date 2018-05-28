package com.mkyong.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mkyong.filter.FilterSpecification;
import com.mkyong.repository.RepoFactory;
import com.mkyong.entity.Class;

@Component
public class ClassService {
	
	@Autowired
	RepoFactory factory;
	
	public List<Class> filter(List<Class> list, FilterSpecification<Class> fs)
	{
		return fs.applyFilter(list);
	}
	
	public List<Class> findAll()
	{
		List<Class> list = new ArrayList<>();
		factory.getRepository("class").findAll().forEach(e -> list.add((Class)e));
		return list;
	}
	
}
