package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.jpa.CourseRepo;
import com.example.demo.jpa.EngRepo;
import com.example.demo.jpa.JpaMemberRepository;
import com.example.demo.jpa.KorRepo;
import com.example.demo.jpa.MathRepo;
import com.example.demo.vo.CourseVo;
import com.example.demo.vo.EngBookVo;
import com.example.demo.vo.KorBookVo;
import com.example.demo.vo.MathBookVo;

import jakarta.servlet.http.HttpServletRequest;

//변경테스트!!!
@Controller
public class mainPage {
	@Autowired
	KorRepo jpaKor;
	@Autowired
	MathRepo jpaMath;
	@Autowired
	EngRepo jpaEng;
	@Autowired
	CourseRepo jpaCourse;
	
	@RequestMapping(value="/index")
	public ModelAndView indexPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	@RequestMapping(value="/searchPage")
	public ModelAndView searchPage(@RequestParam (name="search")String title) {
		ModelAndView mav = new ModelAndView();
		List<CourseVo> courseList = null;
		if(title.length() == 0) {
			mav.addObject("list", courseList);
		}
		else {
			courseList = jpaCourse.selectCourseTitle(title);
			if(courseList.size() == 0) {
				courseList = null;
				mav.addObject("list", courseList);
			}
			else {
			mav.addObject("list", courseList);
			}
		}
		mav.setViewName("searchPage");			
		return mav;
	}
	@RequestMapping(value="/korBook")
	public ModelAndView korBook() {
		ModelAndView mav = new ModelAndView();
		List<KorBookVo> korList = jpaKor.findAll();
		mav.addObject("korList", korList);
		mav.setViewName("korBook");
		return mav;
	}
	@RequestMapping(value="/engBook")
	public ModelAndView engBook() {
		ModelAndView mav = new ModelAndView();
		List<EngBookVo> engList = jpaEng.findAll();
		mav.addObject("engList", engList);
		mav.setViewName("engBook");
		return mav;
	}
	@RequestMapping(value="/mathBook")
	public ModelAndView mathBook() {
		ModelAndView mav = new ModelAndView();
		List<MathBookVo> mathList = jpaMath.findAll();
		mav.addObject("mathList", mathList);
		mav.setViewName("mathBook");
		return mav;
	}
	@RequestMapping(value="/signin")
	public ModelAndView signin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("signin");
		return mav;
	}
	@RequestMapping(value="/login")
	   public ModelAndView login() {
	      ModelAndView mav = new ModelAndView();
	      mav.setViewName("login");
	      return mav;
	   }

	@RequestMapping(value="/memberFind")
	public ModelAndView memberFind() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("memberFind");
		return mav;
		
	}
	@RequestMapping(value="/myPage")
	public ModelAndView myPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("myPage");
		return mav;
	}
	@RequestMapping(value="/adminPage")
	public ModelAndView adminPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("adminPage");
		return mav;
	}

	@RequestMapping(value = "/detailcourse")
	public ModelAndView detail(HttpServletRequest request) {
		String title = request.getParameter("title");
		ModelAndView mav = new ModelAndView();
		CourseVo course = jpaCourse.getById(title);
		mav.addObject("item", course);
		mav.setViewName("detailCourse");

		return mav;
	}
}
