package com.mkyong.filter;

import java.util.ArrayList;
import java.util.List;

import com.mkyong.entity.Class;

public class ProfFilterSpecification implements FilterSpecification<Class> {

	String name;
	
	public ProfFilterSpecification(String name) {
		this.name = name;
	}

	public List<Class> applyFilter(List<Class> list) {
		List<Class> filteredList = new ArrayList<Class>();
		
		for (Class c : list)
		{
			if (c.getProf().getUsername().equals(name))
				filteredList.add(c);
		}
		return filteredList;
	}

}
