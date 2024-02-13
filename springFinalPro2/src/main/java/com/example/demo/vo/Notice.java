package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="notice")
public class Notice {
	@Id
	private int numbers;
	private String title;
	private String writer;
	private String writedate;
	private int views;
	private String writetext;
	
	public int getNumbers() {
		return numbers;
	}
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getWritetext() {
		return writetext;
	}
	public void setWritetext(String writetext) {
		this.writetext = writetext;
	}
	@Override
	public String toString() {
		return "Notice [numbers=" + numbers + ", title=" + title + ", writer=" + writer + ", writedate=" + writedate
				+ ", views=" + views + ", writetext=" + writetext + "]";
	}
	
}