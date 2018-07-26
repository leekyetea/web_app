package org.study.model;

public enum Semester {
	Spring,
	Fall;
	
	public static Semester getSemester(String str) {
		if (str.equalsIgnoreCase("Spring")) {
			return Semester.Spring;
		} else if (str.equalsIgnoreCase("Fall")) {
			return Semester.Fall;
		} else {
			return null;
		}
	}
}
