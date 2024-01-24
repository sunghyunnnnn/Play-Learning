package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "course")
public class CourseVo {
	@Id
	private String title;
	private String target;
	private String courselevel;
	private String description;
	private String videosrc;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getCourselevel() {
		return courselevel;
	}
	public void setCourselevel(String courselevel) {
		this.courselevel = courselevel;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVideosrc() {
		return videosrc;
	}
	public void setVideosrc(String videosrc) {
		this.videosrc = videosrc;
	}
	@Override
	public String toString() {
		return "CourceVo [title=" + title + ", target=" + target + ", courselevel=" + courselevel + ", description="
				+ description + ", videosrc=" + videosrc + "]";
	}
	
	
}
