package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "freetest")
public class FreeBookVo {
	
	@Id
	private int free_no;
	private String free_title;
	private String free_inputname;
	private String free_items1;
	private String free_items2;
	private String free_items3;
	private String free_items4;
	private String free_items5;
	
	public int getFree_no() {
		return free_no;
	}
	public void setFree_no(int free_no) {
		this.free_no = free_no;
	}
	public String getFree_title() {
		return free_title;
	}
	public void setFree_title(String free_title) {
		this.free_title = free_title;
	}
	public String getFree_inputname() {
		return free_inputname;
	}
	public void setFree_inputname(String free_inputname) {
		this.free_inputname = free_inputname;
	}
	public String getFree_items1() {
		return free_items1;
	}
	public void setFree_items1(String free_items1) {
		this.free_items1 = free_items1;
	}
	public String getFree_items2() {
		return free_items2;
	}
	public void setFree_items2(String free_items2) {
		this.free_items2 = free_items2;
	}
	public String getFree_items3() {
		return free_items3;
	}
	public void setFree_items3(String free_items3) {
		this.free_items3 = free_items3;
	}
	public String getFree_items4() {
		return free_items4;
	}
	public void setFree_items4(String free_items4) {
		this.free_items4 = free_items4;
	}
	public String getFree_items5() {
		return free_items5;
	}
	public void setFree_items5(String free_items5) {
		this.free_items5 = free_items5;
	}
	
	@Override
	public String toString() {
		return "FreeBookVo [free_no=" + free_no + ", free_title=" + free_title + ", free_inputname=" + free_inputname
				+ ", free_items1=" + free_items1 + ", free_items2=" + free_items2 + ", free_items3=" + free_items3
				+ ", free_items4=" + free_items4 + ", free_items5=" + free_items5 + "]";
	}
	
	
	
	
	
}
