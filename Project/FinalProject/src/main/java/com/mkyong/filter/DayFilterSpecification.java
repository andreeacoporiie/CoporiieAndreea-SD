package com.mkyong.filter;

import java.util.ArrayList;
import java.util.List;

import com.mkyong.entity.Class;


public class DayFilterSpecification implements FilterSpecification<Class> {

	String day;
	
	public DayFilterSpecification(String day) {
		this.day = day;
	}

	public List<Class> applyFilter(List<Class> list) {
		List<Class> filteredList = new ArrayList<Class>();
		
		for (Class c : list)
		{
			if (c.getDay().equals(day))
				filteredList.add(c);
		}
		return filteredList;
	}

}

