package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "problemmiddlemath")
public class MathMiddleBookVo {
	
	@Id
	private int math_no;
	private String math_title;
	private String math_inputname;
	private String math_items1;
	private String math_items2;
	private String math_items3;
	private String math_items4;
	private String math_items5;
	
	public int getMath_no() {
		return math_no;
	}
	public void setMath_no(int math_no) {
		this.math_no = math_no;
	}
	public String getMath_title() {
		return math_title;
	}
	public void setMath_title(String math_title) {
		this.math_title = math_title;
	}
	public String getMath_inputname() {
		return math_inputname;
	}
	public void setMath_inputname(String math_inputname) {
		this.math_inputname = math_inputname;
	}
	public String getMath_items1() {
		return math_items1;
	}
	public void setMath_items1(String math_items1) {
		this.math_items1 = math_items1;
	}
	public String getMath_items2() {
		return math_items2;
	}
	public void setMath_items2(String math_items2) {
		this.math_items2 = math_items2;
	}
	public String getMath_items3() {
		return math_items3;
	}
	public void setMath_items3(String math_items3) {
		this.math_items3 = math_items3;
	}
	public String getMath_items4() {
		return math_items4;
	}
	public void setMath_items4(String math_items4) {
		this.math_items4 = math_items4;
	}
	public String getMath_items5() {
		return math_items5;
	}
	public void setMath_items5(String math_items5) {
		this.math_items5 = math_items5;
	}
	@Override
	public String toString() {
		return "MathBookVo [math_no=" + math_no + ", math_title=" + math_title + ", math_inputname=" + math_inputname
				+ ", math_items1=" + math_items1 + ", math_items2=" + math_items2 + ", math_items3=" + math_items3
				+ ", math_items4=" + math_items4 + ", math_items5=" + math_items5 + "]";
	}
}
