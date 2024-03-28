package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.jpa.BoardRepo;
import com.example.demo.jpa.CommRepo;
import com.example.demo.vo.Board;
import com.example.demo.vo.CommVo;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CommController {
	@Autowired
	CommRepo commrepo;
	@Autowired
	BoardRepo boardrepo;

	@RequestMapping(value = "/comm")
	public ModelAndView comm(HttpServletRequest request) {
		CommVo commvo = new CommVo();
		List<CommVo> commvolist = new ArrayList<>();
		Board board = new Board();
		int id = (int)Math.round(Math.random() * 1000);
		String comm = request.getParameter("comm");
		String num2 = request.getParameter("num");
		String writer = request.getParameter("writer");
		int num = Integer.parseInt(num2);
		
		System.out.println("comm" + comm );
		commvo.setId(id);
		commvo.setComm(comm);
		commvo.setNum(num);
		commvo.setWriter(writer);
		
		commrepo.save(commvo);
		
		ModelAndView mav = new ModelAndView();
		board = boardrepo.getById(num);
		commvolist = commrepo.selectbynum(num);
		
		
		mav.addObject("list", board);
		mav.addObject("commvolist", commvolist);
		mav.setViewName("admin/board/boardview");

		return mav;
	}

}
