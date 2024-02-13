package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.example.demo.jpa.BoardRepo;
import com.example.demo.jpa.CourseRepo;
import com.example.demo.jpa.EngRepo;
import com.example.demo.jpa.JpaMemberRepository;
import com.example.demo.jpa.KorRepo;
import com.example.demo.jpa.MathRepo;
import com.example.demo.jpa.MypageInfoRepo;

import com.example.demo.jpa.NoticeRepo;

import com.example.demo.vo.Board;

import com.example.demo.jpa.freeTestRepo;

import com.example.demo.vo.CourseVo;
import com.example.demo.vo.EngBookVo;
import com.example.demo.vo.FreeBookVo;
import com.example.demo.vo.KorBookVo;
import com.example.demo.vo.MathBookVo;
import com.example.demo.vo.Member;
import com.example.demo.vo.MypageInfo;
import com.example.demo.vo.Notice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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
	@Autowired
	MypageInfoRepo jpaMypage;
	@Autowired
	BoardRepo jpaBoard;
	@Autowired
	NoticeRepo jpaNotice;
	@Autowired
	freeTestRepo jpaFree;
	

	
	@RequestMapping(value="/index")
	public ModelAndView indexPage(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="/analyze")
	public ModelAndView analyzePage() {
		ModelAndView mav = new ModelAndView();
	
		mav.setViewName("analyze/analyze");
		return mav;
	}
	
	@RequestMapping(value="/freeTest")
	public ModelAndView freeTest() {
		ModelAndView mav = new ModelAndView();
		List<FreeBookVo> freeList = jpaFree.findAll();
		System.out.println(freeList);
		mav.addObject("freeList", freeList);
		mav.setViewName("book/freeTest");
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
		mav.setViewName("search/searchPage");			
		return mav;
	}
	@RequestMapping(value="/korBook")
	public ModelAndView korBook() {
		ModelAndView mav = new ModelAndView();
		List<KorBookVo> korList = jpaKor.findAll();
		mav.addObject("korList", korList);
		mav.setViewName("book/korBook");
		return mav;
	}
	@RequestMapping(value="/engBook")
	public ModelAndView engBook() {
		ModelAndView mav = new ModelAndView();
		List<EngBookVo> engList = jpaEng.findAll();
		mav.addObject("engList", engList);
		mav.setViewName("book/engBook");
		return mav;
	}
	@RequestMapping(value="/mathBook")
	public ModelAndView mathBook() {
		ModelAndView mav = new ModelAndView();
		List<MathBookVo> mathList = jpaMath.findAll();
		mav.addObject("mathList", mathList);
		mav.setViewName("book/mathBook");
		return mav;
	}
	@RequestMapping(value="/myPage")
	public ModelAndView myPage(@RequestParam("id") String id, MypageInfo mypageInfo) {
		ModelAndView mav = new ModelAndView();
		System.out.println("mypage >>" + id);
		List<MypageInfo> mypageArr= null;
		mypageArr = jpaMypage.selectById(id);
		
		System.out.println("mypageInfo >> " + mypageArr.size());
		if(mypageArr.size() == 0) {
			System.out.println("푼 문제 없다.");
			mav.addObject("mypage", "임마 문제 풀어!!!");
		}
		mav.addObject("mypageArr", mypageArr);
		//문제 여러개 배열로 받아야함
		mav.setViewName("member/myPage");
		return mav;
	}
	
	@RequestMapping(value = "/detailcourse")
	public ModelAndView detail(HttpServletRequest request) {
		String title = request.getParameter("title");
		ModelAndView mav = new ModelAndView();
		CourseVo course = jpaCourse.getById(title);
		mav.addObject("item", course);
		mav.setViewName("search/detailCourse");
		return mav;
	}

	@RequestMapping(value = "/adminlogin")
	public ModelAndView adminlogin() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/adminlogin");

		return mav;
	}
	@RequestMapping(value = "/admin")
	public ModelAndView admin() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/admin");

		return mav;
	}
	@RequestMapping(value = "/board")
	public ModelAndView board(Board board) {
		
		ModelAndView mav = new ModelAndView();
		List<Board> boardlist = jpaBoard.findAll();
		System.out.println(boardlist);
		mav.addObject("boardlist",boardlist);
		mav.setViewName("admin/board/boardlist");

		return mav;
	}
	@RequestMapping(value = "/adminnotice")
	public ModelAndView notice() {
		
		ModelAndView mav = new ModelAndView();
		List<Notice> noticelist = jpaNotice.findAll();
		System.out.println(noticelist);
		mav.addObject("noticelist",noticelist);
		mav.setViewName("admin/notice/noticelist");

		return mav;
	}
	@RequestMapping(value = "/boardregister")
	public ModelAndView boardregister(Board boardvo) {
		
		ModelAndView mav = new ModelAndView();
		jpaBoard.save(boardvo);
		List<Board> boardlist = jpaBoard.findAll();
		mav.addObject("boardlist",boardlist);
		mav.setViewName("admin/board/boardlist");
		System.out.println(boardvo);
		return mav;
	}
	@RequestMapping(value = "/boardwrite")
	public ModelAndView boardview() {
		
		ModelAndView mav = new ModelAndView();
		
		
		
		mav.setViewName("admin/board/boardwrite");

		return mav;
	}
	@RequestMapping(value = "/noticewrite")
	public ModelAndView noticeview() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/notice/noticewrite");

		return mav;
	}
}
