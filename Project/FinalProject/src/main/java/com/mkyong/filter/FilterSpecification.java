package com.mkyong.filter;

import java.util.List;

public interface FilterSpecification<T> {
	
	public List<T> applyFilter(List<T> list);
}
