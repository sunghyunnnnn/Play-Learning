package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.jpa.BoardRepo;
import com.example.demo.jpa.CommRepo;
import com.example.demo.vo.Board;
import com.example.demo.vo.CommVo;
@Controller
public class CommController {
	@Autowired
	CommRepo commrepo;
	@Autowired
	BoardRepo boardrepo;
	
	@RequestMapping(value="/comm")
	public ModelAndView comm(CommVo commvo) {
		
		String input_id = commvo.getId();
		String input_comm = commvo.getComm();
		int input_num = commvo.getNum();
		
		Board board = boardrepo.getById(input_num);
		
		commrepo.save(commvo);
		CommVo comvo = commrepo.getById(input_id);

		ModelAndView mav = new ModelAndView();
		mav.addObject("list", board);
		 
		mav.addObject("commvo", comvo);
		mav.setViewName("admin/board/boardview");
		
		return mav;
	}

}


