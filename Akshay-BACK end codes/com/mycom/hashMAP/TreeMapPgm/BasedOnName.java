package com.mycom.hashMAP.TreeMapPgm;

import java.util.Comparator;

public class BasedOnName implements Comparator<StudentEx>{

	@Override
	public int compare(StudentEx o1, StudentEx o2) {
		return o1.name.compareTo(o2.name);
	}
	

}
