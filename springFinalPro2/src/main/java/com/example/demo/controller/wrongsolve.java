package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class wrongsolve {

	@RequestMapping(value="/wrongsolve")
	public ModelAndView wrongsolve() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("book/wrongsolve");
		return mav;
		
		
	}
	
}


