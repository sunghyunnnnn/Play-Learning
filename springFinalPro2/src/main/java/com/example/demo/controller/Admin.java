package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.jpa.JpaMemberRepository;

@Controller
public class Admin {
	@Autowired
	JpaMemberRepository memberJpa;
	
	@RequestMapping(value = "/memberGraph")
	public ModelAndView memberGraph() {
		ModelAndView mav = new ModelAndView();
		int totalCnt = memberJpa.selectCountById();
		int manCnt = memberJpa.selectCountByman();
		int girlCnt = memberJpa.selectCountBygirl();
//		System.out.println("total : " + totalCnt + "man : " + manCnt + "girl : " + girlCnt);
		
		mav.addObject("total", totalCnt);
		mav.addObject("manCnt", manCnt);
		mav.addObject("girlCnt", girlCnt);
		
		
		mav.setViewName("/admin/graph/memberGraph");
		return mav;
	}
}
