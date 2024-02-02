package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.jpa.EngRepo;
import com.example.demo.jpa.KorRepo;
import com.example.demo.jpa.MathRepo;
import com.example.demo.jpa.MypageInfoRepo;
import com.example.demo.vo.EngBookVo;
import com.example.demo.vo.KorBookVo;
import com.example.demo.vo.MathBookVo;
import com.example.demo.vo.MypageInfo;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ResultBook {
	List<String> korAnswer = new ArrayList<>(List.of("호떡", "제비", "열대어", "동화책", "쿠키", "꽃시장", "꼬리잡기", "책읽기", "책쌓기", "방망이 얻기"));
	List<String> mathAnswer = new ArrayList<>(List.of("23", "73", "41", "1441", "1077", "354", "1689", "265", "553", "1147"));
	List<String> engAnswer = new ArrayList<>(List.of("Good-bye", "teacher-삼촌", "What", "캐나다", "that", "kite", "Open", "Too bad", "three", "스키"));
	List<MypageInfo> mypageInfo = new ArrayList<>();
	@Autowired
	KorRepo jpaKor;
	@Autowired
	MathRepo jpaMath;
	@Autowired
	EngRepo jpaEng;
	@Autowired
	MypageInfoRepo jpaMypage;
	
//	              name(혹은value) 반환형태        변수명
//	@RequestParam(name="wrong") List<String> values
	@RequestMapping(value = "/wrongKorPage")
	public ModelAndView wrongKorPage(@RequestParam(name="wrong") List<String> values, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String[] wrongAnswer = new String[values.size()];
		List<KorBookVo> korList = new ArrayList<>();
		
		for(int i = 0; i < values.size(); i++) {
			korList.add(jpaKor.selectKorBookById(values.get(i)));
		}
		
		System.out.println("이건가 ?? " + values);
		int index = 0;
		int i = 0;
		while(true) {
			if(i > values.size() - 1) {
				break;
			}
			index = Integer.parseInt(values.get(i));
			wrongAnswer[i] = korAnswer.get(index - 1);
//			wrongAnswer.add(answer.get(index - 1));
			i++;
		}
		
//		System.out.println(wrongAnswer[0]);
		session.setAttribute("wrongKorAnswer", wrongAnswer);
		mav.addObject("korList", korList);
		mav.setViewName("book/wrongKorPage");
		return mav;
	}	
	@RequestMapping(value = "/resultKorBook")
	public ModelAndView korResult(HttpServletRequest request, MypageInfo mypageInfo) {
		ModelAndView mav = new ModelAndView();
		List<String> result = new ArrayList<>();
		List<Integer> wrong = new ArrayList<>();
		String result1 = request.getParameter("kor1");
		String result2 = request.getParameter("kor2");
		String result3 = request.getParameter("kor3");
		String result4 = request.getParameter("kor4");
		String result5 = request.getParameter("kor5");
		String result6 = request.getParameter("kor6");
		String result7 = request.getParameter("kor7");
		String result8 = request.getParameter("kor8");
		String result9 = request.getParameter("kor9");
		String result10 = request.getParameter("kor10");
		String examAnswer = "";
		int korNo;
		result.add(result1);
		result.add(result2);
		result.add(result3);
		result.add(result4);
		result.add(result5);
		result.add(result6);
		result.add(result7);
		result.add(result8);
		result.add(result9);
		result.add(result10);
		
		int success = 0;
		int fail = 0;
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).equals(korAnswer.get(i))) {
				success++;
			}
			else {
				korNo = i + 1;
				wrong.add(korNo);
			}

		}
		fail = result.size() - success;
		if(fail <= result.size() * 0.2) {
			examAnswer = "매우 우수";
		}
		else if(fail <= result.size() * 0.4 && fail > result.size() * 0.2) {
			examAnswer = "우수";
		}
		else if(fail <= result.size() / 2 && fail > result.size() * 0.4) {
			examAnswer = "보통";
		}
		else {
			examAnswer = "노력요함";
		}
		System.out.println(mypageInfo);
		mypageInfo.setSubjecttitle("국어");
		mypageInfo.setSubjectlevel("가볍게 워밍업!!");
		mypageInfo.setSubjectresult(examAnswer);
		System.out.println("마이페이지 >> " + mypageInfo);
		jpaMypage.save(mypageInfo);
		mav.addObject("examAnswer", examAnswer);
		mav.addObject("wrong", wrong);
		mav.addObject("list", result);
		mav.addObject("success", success);
		mav.addObject("fail", fail);
		mav.setViewName("book/resultKor");
		return mav;
	}
	@RequestMapping(value = "/wrongMathPage")
	public ModelAndView wrongMathPage(@RequestParam(name="wrong") List<String> values, HttpSession session) {
		ModelAndView mav = new ModelAndView();
//		List<String> wrongAnswer = new ArrayList<>();
		String[] wrongAnswer = new String[values.size()];
		List<MathBookVo> mathList = new ArrayList<>();
		
		for(int i = 0; i < values.size(); i++) {
			mathList.add(jpaMath.selectMathBookById(values.get(i)));
		}
		System.out.println("이건가 ?? " + values);
		int index = 0;
		int i = 0;
		while(true) {
			if(i > values.size() - 1) {
				break;
			}
			index = Integer.parseInt(values.get(i));
			wrongAnswer[i] = mathAnswer.get(index - 1);
//			wrongAnswer.add(answer.get(index - 1));
			i++;
		}
		
//		System.out.println(wrongAnswer[0]);
		session.setAttribute("wrongMathAnswer", wrongAnswer);
		mav.addObject("mathList", mathList);
		mav.setViewName("book/wrongMathPage");
		return mav;
	}
	@RequestMapping(value = "resultMathBook")
	public ModelAndView mahtResult(HttpServletRequest request, MypageInfo mypageInfo) {
		ModelAndView mav = new ModelAndView();
		List<String> result = new ArrayList<>();
		
		List<Integer> wrong = new ArrayList<>();
		String result1 = request.getParameter("math1");
		String result2 = request.getParameter("math2");
		String result3 = request.getParameter("math3");
		String result4 = request.getParameter("math4");
		String result5 = request.getParameter("math5");
		String result6 = request.getParameter("math6");
		String result7 = request.getParameter("math7");
		String result8 = request.getParameter("math8");
		String result9 = request.getParameter("math9");
		String result10 = request.getParameter("math10");
		String examAnswer = "";
		int mathNo;
		result.add(result1);
		result.add(result2);
		result.add(result3);
		result.add(result4);
		result.add(result5);
		result.add(result6);
		result.add(result7);
		result.add(result8);
		result.add(result9);
		result.add(result10);
		int success = 0;
		int fail = 0;
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).equals(mathAnswer.get(i))) {
				success++;
			}
			else {
				mathNo = i + 1;
				wrong.add(mathNo);
			}

		}
		fail = result.size() - success;
		if(fail <= result.size() * 0.2) {
			examAnswer = "매우 우수";
		}
		else if(fail <= result.size() * 0.4 && fail > result.size() * 0.2) {
			examAnswer = "우수";
		}
		else if(fail <= result.size() / 2 && fail > result.size() * 0.4) {
			examAnswer = "보통";
		}
		else {
			examAnswer = "노력요함";
		}
		mypageInfo.setSubjecttitle("수학");
		mypageInfo.setSubjectlevel("가볍게 워밍업!!");
		mypageInfo.setSubjectresult(examAnswer);
		System.out.println("마이페이지 >> " + mypageInfo);
		jpaMypage.save(mypageInfo);
		mav.addObject("examAnswer", examAnswer);
		mav.addObject("wrong", wrong);
		mav.addObject("list", result);
		mav.addObject("success", success);
		mav.addObject("fail", fail);
		mav.setViewName("book/resultMath");
		return mav;
	}
	@RequestMapping(value = "/wrongEngPage")
	public ModelAndView wrongEngPage(@RequestParam(name="wrong") List<String> values, HttpSession session) {
		ModelAndView mav = new ModelAndView();
//		List<String> wrongAnswer = new ArrayList<>();
		String[] wrongAnswer = new String[values.size()];
		List<EngBookVo> engList = new ArrayList<>();
		
		for(int i = 0; i < values.size(); i++) {
			engList.add(jpaEng.selectEngBookById(values.get(i)));
		}
		System.out.println("이건가 ?? " + values);
		int index = 0;
		int i = 0;
		while(true) {
			if(i > values.size() - 1) {
				break;
			}
			index = Integer.parseInt(values.get(i));
			wrongAnswer[i] = engAnswer.get(index - 1);
//			wrongAnswer.add(answer.get(index - 1));
			i++;
		}
		
//		System.out.println(wrongAnswer[0]);
		session.setAttribute("wrongEngAnswer", wrongAnswer);
		mav.addObject("engList", engList);
		mav.setViewName("book/wrongEngPage");
		return mav;
	}
	@RequestMapping(value = "resultEngBook")
	public ModelAndView engResult(HttpServletRequest request, MypageInfo mypageInfo) {
		ModelAndView mav = new ModelAndView();
		List<String> result = new ArrayList<>();
		
		List<Integer> wrong = new ArrayList<>();
		String result1 = request.getParameter("eng1");
		String result2 = request.getParameter("eng2");
		String result3 = request.getParameter("eng3");
		String result4 = request.getParameter("eng4");
		String result5 = request.getParameter("eng5");
		String result6 = request.getParameter("eng6");
		String result7 = request.getParameter("eng7");
		String result8 = request.getParameter("eng8");
		String result9 = request.getParameter("eng9");
		String result10 = request.getParameter("eng10");
		String examAnswer = "";
		int engNo;
		result.add(result1);
		result.add(result2);
		result.add(result3);
		result.add(result4);
		result.add(result5);
		result.add(result6);
		result.add(result7);
		result.add(result8);
		result.add(result9);
		result.add(result10);
		
		int success = 0;
		int fail = 0;
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).equals(engAnswer.get(i))) {
				success++;
			}
			else {
				engNo= i + 1;
				wrong.add(engNo);
			}

		}
		fail = result.size() - success;
		if(fail <= result.size() * 0.2) {
			examAnswer = "매우 우수";
		}
		else if(fail <= result.size() * 0.4 && fail > result.size() * 0.2) {
			examAnswer = "우수";
		}
		else if(fail <= result.size() / 2 && fail > result.size() * 0.4) {
			examAnswer = "보통";
		}
		else {
			examAnswer = "노력요함";
		}
		mypageInfo.setSubjecttitle("영어");
		mypageInfo.setSubjectlevel("가볍게 워밍업!!");
		mypageInfo.setSubjectresult(examAnswer);
		System.out.println("마이페이지 >> " + mypageInfo);
		jpaMypage.save(mypageInfo);
		mav.addObject("examAnswer", examAnswer);
		mav.addObject("wrong", wrong);
		mav.addObject("list", result);
		mav.addObject("success", success);
		mav.addObject("fail", fail);
		mav.setViewName("book/resultEng");
		return mav;
	}
}
