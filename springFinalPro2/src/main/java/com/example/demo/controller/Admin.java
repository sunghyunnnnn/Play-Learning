package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.jpa.GradeBankRepo;
import com.example.demo.jpa.JpaMemberRepository;
import com.example.demo.vo.GradeBankVo;

@Controller
public class Admin {
	@Autowired
	JpaMemberRepository memberJpa;
	@Autowired
	GradeBankRepo gradeBankJpa;
	@RequestMapping(value = "/memberGraph")
	public ModelAndView memberGraph() {
		ModelAndView mav = new ModelAndView();
		
		int totalCnt = memberJpa.selectCountById();
		int manCnt = memberJpa.selectCountByman();
		int girlCnt = memberJpa.selectCountBygirl();
		
		int totalMoney = gradeBankJpa.selectTotalMoney();
		int preMoney = gradeBankJpa.selectPreMoney();
		int genMoney = gradeBankJpa.selectGenMoney();

//		System.out.println(totalMoney + " / " + preMoney + " / " + genMoney);

		mav.addObject("total", totalCnt);
		mav.addObject("manCnt", manCnt);
		mav.addObject("girlCnt", girlCnt);

		mav.addObject("totalMoney", totalMoney);
		mav.addObject("preMoney", preMoney);
		mav.addObject("genMoney", genMoney);
		
		mav.setViewName("/admin/graph/memberGraph");
		return mav;
	}
}
