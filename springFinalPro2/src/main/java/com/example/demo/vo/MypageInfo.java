package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "mypageinfo")
public class MypageInfo {
	
	@Id
	private String subjecttitle;
	private String id;
	private String subjectlevel;
	private String subjectresult;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubjecttitle() {
		return subjecttitle;
	}
	public void setSubjecttitle(String subjecttitle) {
		this.subjecttitle = subjecttitle;
	}
	public String getSubjectlevel() {
		return subjectlevel;
	}
	public void setSubjectlevel(String subjectlevel) {
		this.subjectlevel = subjectlevel;
	}
	public String getSubjectresult() {
		return subjectresult;
	}
	public void setSubjectresult(String subjectresult) {
		this.subjectresult = subjectresult;
	}
	@Override
	public String toString() {
		return "MypageInfo [subjecttitle=" + subjecttitle + ", subjectlevel=" + subjectlevel + ", subjectresult="
				+ subjectresult + ", id=" + id + "]";
	}
	
}
