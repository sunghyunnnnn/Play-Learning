package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "gradebank")
public class GradeBankVo {
	@Id
	private double id;
	private int premoney;
	private int genmoney;
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	public int getPremoney() {
		return premoney;
	}
	public void setPremoney(int premoney) {
		this.premoney = premoney;
	}
	public int getGenmoney() {
		return genmoney;
	}
	public void setGenmoney(int genmoney) {
		this.genmoney = genmoney;
	}
	@Override
	public String toString() {
		return "GradeBankVo [id=" + id + ", premoney=" + premoney + ", genmoney=" + genmoney + "]";
	}
	
	
	
}
