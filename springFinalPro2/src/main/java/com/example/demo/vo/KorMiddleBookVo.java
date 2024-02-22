package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="problemmiddlekor")
public class KorMiddleBookVo {
	@Id
	private int kor_no;
	private String kor_title;
	private String kor_img;
	private String kor_inputname;
	private String kor_items1;
	private String kor_items2;
	private String kor_items3;
	private String kor_items4;
	private String kor_items5;
	
	public int getKor_no() {
		return kor_no;
	}
	public void setKor_no(int kor_no) {
		this.kor_no = kor_no;
	}
	public String getKor_title() {
		return kor_title;
	}
	public void setKor_title(String kor_title) {
		this.kor_title = kor_title;
	}
	public String getKor_img() {
		return kor_img;
	}
	public void setKor_img(String kor_img) {
		this.kor_img = kor_img;
	}
	public String getKor_inputname() {
		return kor_inputname;
	}
	public void setKor_inputname(String kor_inputname) {
		this.kor_inputname = kor_inputname;
	}
	public String getKor_items1() {
		return kor_items1;
	}
	public void setKor_items1(String kor_items1) {
		this.kor_items1 = kor_items1;
	}
	public String getKor_items2() {
		return kor_items2;
	}
	public void setKor_items2(String kor_items2) {
		this.kor_items2 = kor_items2;
	}
	public String getKor_items3() {
		return kor_items3;
	}
	public void setKor_items3(String kor_items3) {
		this.kor_items3 = kor_items3;
	}
	public String getKor_items4() {
		return kor_items4;
	}
	public void setKor_items4(String kor_items4) {
		this.kor_items4 = kor_items4;
	}
	public String getKor_items5() {
		return kor_items5;
	}
	public void setKor_items5(String kor_items5) {
		this.kor_items5 = kor_items5;
	}
	@Override
	public String toString() {
		return "KorBookVo [kor_no=" + kor_no + ", kor_title=" + kor_title + ", kor_img=" + kor_img + ", kor_inputname="
				+ kor_inputname + ", kor_items1=" + kor_items1 + ", kor_items2=" + kor_items2 + ", kor_items3="
				+ kor_items3 + ", kor_items4=" + kor_items4 + ", kor_items5=" + kor_items5 + "]";
	}
	
	
}
