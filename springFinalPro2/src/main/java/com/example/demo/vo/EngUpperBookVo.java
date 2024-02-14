package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "problemuppereng")
public class EngUpperBookVo {

	@Id
	private int eng_no;
	private String eng_title;
	private String eng_inputname;
	private String eng_items1;
	private String eng_items2;
	private String eng_items3;
	private String eng_items4;
	private String eng_items5;
	
	public int getEng_no() {
		return eng_no;
	}
	public void setEng_no(int eng_no) {
		this.eng_no = eng_no;
	}
	public String getEng_title() {
		return eng_title;
	}
	public void setEng_title(String eng_title) {
		this.eng_title = eng_title;
	}
	public String getEng_inputname() {
		return eng_inputname;
	}
	public void setEng_inputname(String eng_inputname) {
		this.eng_inputname = eng_inputname;
	}
	public String getEng_items1() {
		return eng_items1;
	}
	public void setEng_items1(String eng_items1) {
		this.eng_items1 = eng_items1;
	}
	public String getEng_items2() {
		return eng_items2;
	}
	public void setEng_items2(String eng_items2) {
		this.eng_items2 = eng_items2;
	}
	public String getEng_items3() {
		return eng_items3;
	}
	public void setEng_items3(String eng_items3) {
		this.eng_items3 = eng_items3;
	}
	public String getEng_items4() {
		return eng_items4;
	}
	public void setEng_items4(String eng_items4) {
		this.eng_items4 = eng_items4;
	}
	public String getEng_items5() {
		return eng_items5;
	}
	public void setEng_items5(String eng_items5) {
		this.eng_items5 = eng_items5;
	}
	
	@Override
	public String toString() {
		return "EngBookVo [eng_no=" + eng_no + ", eng_title=" + eng_title + ", eng_inputname=" + eng_inputname
				+ ", eng_items1=" + eng_items1 + ", eng_items2=" + eng_items2 + ", eng_items3=" + eng_items3
				+ ", eng_items4=" + eng_items4 + ", eng_items5=" + eng_items5 + "]";
	}
}
