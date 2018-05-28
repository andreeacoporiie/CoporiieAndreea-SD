package com.mkyong.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mkyong.entity.Student;
import com.mkyong.repository.RepoFactory;

@Component
public class StudentService {

	@Autowired
	RepoFactory factory;
	
	public List<Student> findAll()
	{
		List<Student> list = new ArrayList<>();
		factory.getRepository("student").findAll().forEach(e -> list.add((Student)e));
		return list;
	}
	
	public Student findByUser(String username)
	{
		List<Student> list = findAll();
		for (Student s : list)
		{
			if (s.getUsername().equals(username))
				return s;
		}
		return null;
	}

	//alternative for strategy
	public List<Student> filterByGr(int group)
	{
		List<Student> list = findAll();
		List<Student> filtered = new ArrayList<>();
		for (Student s : list)
		{
			if (s.getGroup().getIdGroup() == group)
				filtered.add(s);
		}
		return filtered;
	}
	
}
