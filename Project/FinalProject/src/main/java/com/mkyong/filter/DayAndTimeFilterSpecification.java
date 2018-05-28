package com.mkyong.filter;

import java.util.ArrayList;
import java.util.List;

import com.mkyong.entity.Class;

public class DayAndTimeFilterSpecification implements FilterSpecification<Class> {

	String day;
	int time;
	
	public DayAndTimeFilterSpecification(String day, int time) {
		this.day = day;
		this.time = time;
	}

	public List<Class> applyFilter(List<Class> list) {
		List<Class> filteredList = new ArrayList<Class>();
		
		for (Class c : list)
		{
			if (c.getDay().equals(day) && c.getTime() == time)
				filteredList.add(c);
		}
		return filteredList;
	}

}
