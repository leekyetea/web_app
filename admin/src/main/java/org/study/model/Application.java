package org.study.model;

import java.util.Date;

public class Application {

	int id;
	String userId;
	String major;
	Semester semester;
	String applyDesc;

	public Application(String userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public String getApplyDesc() {
		return applyDesc;
	}

	public void setApplyDesc(String applyDesc) {
		this.applyDesc = applyDesc;
	}

	@Override
	public String toString() {
		return "Application [userId=" + userId + ", major=" + major + ", semester=" + semester + ", applyDesc="
				+ applyDesc + "]";
	}

}
