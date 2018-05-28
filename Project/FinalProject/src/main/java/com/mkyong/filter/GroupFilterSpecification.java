package com.mkyong.filter;

import com.mkyong.entity.Class;

import java.util.ArrayList;
import java.util.List;

public class GroupFilterSpecification implements FilterSpecification<Class> {

	int group;
	
	public GroupFilterSpecification(int group) {
		this.group = group;
	}

	public List<Class> applyFilter(List<Class> list) {
		List<Class> filteredList = new ArrayList<Class>();
		
		for (Class c : list)
		{
			if (c.getGroup().getIdGroup() == group)
				filteredList.add(c);
		}
		return filteredList;
	}

}
