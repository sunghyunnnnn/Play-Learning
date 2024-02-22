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

import com.example.demo.jpa.EngMiddleRepo;
import com.example.demo.jpa.EngRepo;
import com.example.demo.jpa.EngUpperRepo;
import com.example.demo.jpa.KorMiddleRepo;
import com.example.demo.jpa.KorRepo;
import com.example.demo.jpa.KorUpperRepo;
import com.example.demo.jpa.MathMiddleRepo;
import com.example.demo.jpa.MathRepo;
import com.example.demo.jpa.MathUpperRepo;
import com.example.demo.jpa.MypageInfoRepo;
import com.example.demo.vo.EngBookVo;
import com.example.demo.vo.EngMiddleBookVo;
import com.example.demo.vo.EngUpperBookVo;
import com.example.demo.vo.KorBookVo;
import com.example.demo.vo.KorMiddleBookVo;
import com.example.demo.vo.KorUpperBookVo;
import com.example.demo.vo.MathBookVo;
import com.example.demo.vo.MathMiddleBookVo;
import com.example.demo.vo.MathUpperBookVo;
import com.example.demo.vo.MypageInfo;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ResultBook {
	List<String> korAnswer = new ArrayList<>(List.of("호떡", "제비", "열대어", "동화책", "쿠키", "꽃시장", "꼬리잡기", "책읽기", "책쌓기", "방망이 얻기"));
	List<String> korUpperAnswer = new ArrayList<>(List.of("가는 날이 장날", "까마귀 날자 배 떨어진다", "도둑이 제 발 저리다", "겨 묻은 개가 똥 묻은 개를 나무란다.", "거미도 줄을 쳐야 벌레를 잡는다", "계란으로 바위 치기", "가재는 게 편", "가는 말이 고와야 오는 말이 곱다", "새해 못할 제사 있으랴", "달면 삼키고 쓰면 뱉는다"));
	List<String> korMiddleAnswer = new ArrayList<>(List.of("ⓐ와 비슷한 변화를 겪은 단어에는 ‘슈룹’이 있다.", "‘그’로 인해 다른 사람들도 ‘침대’를 ‘사진’이라 부르게 될 수 있다.", "‘갑자기’와 ‘내리다’는 문장에서 쓰일 때, 형태가 변하지 않는 단어이다.", "ⓑ, ⓒ, ⓕ", "문장에서 주로 주어, 목적어 등이 되는 자리에 온다.", "‘다’는 문장의 끝에서 문장의 종결을 알려 주는 역할을 하는 조사이다.", "ⓑ와 ⓒ의 ‘만’과 ‘도’는 체언에 붙어 특별한 의미를 더해 주는 조사이다.", "동사: 넓네, 깨끗해", "ⓓ, ⓕ", "진수: 또 그래서 단어를 내 마음대로 바꿀 수 없는 건가 봐."));
	
	
	List<String> mathAnswer = new ArrayList<>(List.of("23", "73", "41", "1441", "1077", "354", "1689", "265", "553", "1147"));	
	List<String> mathUpperAnswer = new ArrayList<>(List.of("8", "12", "3,4,12,15", "5,10,15,20", "7,14,21,28", "13.64", "8.41", "200.96", "50.24", "254.34"));
	List<String> mathMiddleAnswer = new ArrayList<>(List.of("6", "y=3/8x", "y=1/4x", "1", "-5", "y=3/2x", "제1사분면, 제2사분면을 지난다.", "9시간", "y=60/x", "21"));
	
	List<String> engAnswer = new ArrayList<>(List.of("Good-bye", "teacher-삼촌", "What", "캐나다", "that", "kite", "Open", "Too bad", "three", "스키"));
	List<String> engUpperAnswer = new ArrayList<>(List.of("Nice to meet you", "7시", "I get up at six", "evening", "학교의 위치", "go to school", "여기", "store", "toy store", "I will visit my uncle in London"));
	List<String> engMiddleAnswer = new ArrayList<>(List.of("go-goes", "buy-brought", "I amn’t from France.", "Two pair of floves are over there.", "are reading", "tomorrow", "We must pass the exam this time.", "cheese", "It is very pretty doll.", "is going to"));
	
	List<MypageInfo> mypageInfo = new ArrayList<>();
	@Autowired
	KorRepo jpaKor;
	@Autowired
	MathRepo jpaMath;
	@Autowired
	EngRepo jpaEng;
	@Autowired
	KorUpperRepo jpaKorUpper;
	@Autowired
	MathUpperRepo jpaMathUpper;
	@Autowired
	KorMiddleRepo jpaKorMiddle;
	@Autowired
	MathMiddleRepo jpaMathMiddle;
	@Autowired
	EngMiddleRepo jpaEngMiddle;
	@Autowired
	EngUpperRepo jpaEngUpper;
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
	
	@RequestMapping(value = "/wrongKorUpperPage")
	public ModelAndView wrongKorUpperPage(@RequestParam(name="wrong") List<String> values, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		String[] wrongAnswer = new String[values.size()];
		List<KorUpperBookVo> korList = new ArrayList<>();
		
		for(int i = 0; i < values.size(); i++) {
			korList.add(jpaKorUpper.selectKorBookById(values.get(i)));
		}
		
		System.out.println("이건가 ?? " + values);
		int index = 0;
		int i = 0;
		while(true) {
			if(i > values.size() - 1) {
				break;
			}
			index = Integer.parseInt(values.get(i));
			wrongAnswer[i] = korUpperAnswer.get(index - 1);
//			wrongAnswer.add(answer.get(index - 1));
			i++;
		}
		
//		System.out.println(wrongAnswer[0]);
		session.setAttribute("wrongKorAnswer", wrongAnswer);
		mav.addObject("korList", korList);
		mav.setViewName("book/wrongKorUpperPage");
		return mav;
	}
	@RequestMapping(value = "/wrongKorMiddlePage")
	public ModelAndView wrongKorMiddlePage(@RequestParam(name="wrong") List<String> values, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		String[] wrongAnswer = new String[values.size()];
		List<KorMiddleBookVo> korList = new ArrayList<>();
		
		for(int i = 0; i < values.size(); i++) {
			korList.add(jpaKorMiddle.selectKorBookById(values.get(i)));
		}
		
		System.out.println("이건가 ?? " + values);
		int index = 0;
		int i = 0;
		while(true) {
			if(i > values.size() - 1) {
				break;
			}
			index = Integer.parseInt(values.get(i));
			wrongAnswer[i] = korMiddleAnswer.get(index - 1);
//			wrongAnswer.add(answer.get(index - 1));
			i++;
		}
		
//		System.out.println(wrongAnswer[0]);
		session.setAttribute("wrongKorAnswer", wrongAnswer);
		mav.addObject("korList", korList);
		mav.setViewName("book/wrongKorMiddlePage");
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
		mypageInfo.setSubjecttitle("국어(저학년)");
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
	@RequestMapping(value = "/resultKorUpperBook")
	public ModelAndView korUpperResult(HttpServletRequest request, MypageInfo mypageInfo) {
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
			if (result.get(i).equals(korUpperAnswer.get(i))) {
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
		mypageInfo.setSubjecttitle("국어(고학년)");
		mypageInfo.setSubjectlevel("무겁게 워밍업!!");
		mypageInfo.setSubjectresult(examAnswer);
		System.out.println("마이페이지 >> " + mypageInfo);
		jpaMypage.save(mypageInfo);
		mav.addObject("examAnswer", examAnswer);
		mav.addObject("wrong", wrong);
		mav.addObject("list", result);
		mav.addObject("success", success);
		mav.addObject("fail", fail);
		mav.setViewName("book/resultKorUpper");
		return mav;
	}
	@RequestMapping(value = "/resultKorMiddleBook")
	public ModelAndView korMiddleResult(HttpServletRequest request, MypageInfo mypageInfo) {
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
			if (result.get(i).equals(korMiddleAnswer.get(i))) {
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
		mypageInfo.setSubjecttitle("수학(중학교)");
		mypageInfo.setSubjectlevel("빡세게 워밍업!!");
		mypageInfo.setSubjectresult(examAnswer);
		System.out.println("마이페이지 >> " + mypageInfo);
		jpaMypage.save(mypageInfo);
		mav.addObject("examAnswer", examAnswer);
		mav.addObject("wrong", wrong);
		mav.addObject("list", result);
		mav.addObject("success", success);
		mav.addObject("fail", fail);
		mav.setViewName("book/resultKorMiddle");
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
	@RequestMapping(value = "/wrongMathUpperPage")
	public ModelAndView wrongMathUpperPage(@RequestParam(name="wrong") List<String> values, HttpSession session) {
		ModelAndView mav = new ModelAndView();
//		List<String> wrongAnswer = new ArrayList<>();
		String[] wrongAnswer = new String[values.size()];
		List<MathUpperBookVo> mathList = new ArrayList<>();
		
		for(int i = 0; i < values.size(); i++) {
			mathList.add(jpaMathUpper.selectMathBookById(values.get(i)));
		}
		System.out.println("이건가 ?? " + values);
		int index = 0;
		int i = 0;
		while(true) {
			if(i > values.size() - 1) {
				break;
			}
			index = Integer.parseInt(values.get(i));
			wrongAnswer[i] = mathUpperAnswer.get(index - 1);
//			wrongAnswer.add(answer.get(index - 1));
			i++;
		}
		
//		System.out.println(wrongAnswer[0]);
		session.setAttribute("wrongMathAnswer", wrongAnswer);
		mav.addObject("mathList", mathList);
		mav.setViewName("book/wrongMathUpperPage");
		return mav;
	}
	@RequestMapping(value = "/wrongMathMiddlePage")
	public ModelAndView wrongMathMiddlePage(@RequestParam(name="wrong") List<String> values, HttpSession session) {
		ModelAndView mav = new ModelAndView();
//		List<String> wrongAnswer = new ArrayList<>();
		String[] wrongAnswer = new String[values.size()];
		List<MathMiddleBookVo> mathList = new ArrayList<>();
		
		for(int i = 0; i < values.size(); i++) {
			mathList.add(jpaMathMiddle.selectMathBookById(values.get(i)));
		}
		System.out.println("이건가 ?? " + values);
		int index = 0;
		int i = 0;
		while(true) {
			if(i > values.size() - 1) {
				break;
			}
			index = Integer.parseInt(values.get(i));
			wrongAnswer[i] = mathMiddleAnswer.get(index - 1);
//			wrongAnswer.add(answer.get(index - 1));
			i++;
		}
		
//		System.out.println(wrongAnswer[0]);
		session.setAttribute("wrongMathAnswer", wrongAnswer);
		mav.addObject("mathList", mathList);
		mav.setViewName("book/wrongMathMiddlePage");
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
		mypageInfo.setSubjecttitle("수학(저학년)");
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
	@RequestMapping(value = "resultMathUpperBook")
	public ModelAndView mahtUpperResult(HttpServletRequest request, MypageInfo mypageInfo) {
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
			if (result.get(i).equals(mathUpperAnswer.get(i))) {
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
		mypageInfo.setSubjecttitle("수학(고학년)");
		mypageInfo.setSubjectlevel("무겁게 워밍업!!");
		mypageInfo.setSubjectresult(examAnswer);
		System.out.println("마이페이지 >> " + mypageInfo);
		jpaMypage.save(mypageInfo);
		mav.addObject("examAnswer", examAnswer);
		mav.addObject("wrong", wrong);
		mav.addObject("list", result);
		mav.addObject("success", success);
		mav.addObject("fail", fail);
		mav.setViewName("book/resultMathUpper");
		return mav;
	}
	@RequestMapping(value = "resultMathMiddleBook")
	public ModelAndView mahtMiddleResult(HttpServletRequest request, MypageInfo mypageInfo) {
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
			if (result.get(i).equals(mathMiddleAnswer.get(i))) {
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
		mypageInfo.setSubjecttitle("수학(중학교)");
		mypageInfo.setSubjectlevel("빡세게 워밍업!!");
		mypageInfo.setSubjectresult(examAnswer);
		System.out.println("마이페이지 >> " + mypageInfo);
		jpaMypage.save(mypageInfo);
		mav.addObject("examAnswer", examAnswer);
		mav.addObject("wrong", wrong);
		mav.addObject("list", result);
		mav.addObject("success", success);
		mav.addObject("fail", fail);
		mav.setViewName("book/resultMathMiddle");
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
	
	@RequestMapping(value = "/wrongEngUpperPage")
	public ModelAndView wrongEngUpperPage(@RequestParam(name="wrong") List<String> values, HttpSession session) {
		ModelAndView mav = new ModelAndView();
//		List<String> wrongAnswer = new ArrayList<>();
		String[] wrongAnswer = new String[values.size()];
		List<EngUpperBookVo> engList = new ArrayList<>();
		
		for(int i = 0; i < values.size(); i++) {
			engList.add(jpaEngUpper.selectEngBookById(values.get(i)));
		}
		System.out.println("이건가 ?? " + values);
		int index = 0;
		int i = 0;
		while(true) {
			if(i > values.size() - 1) {
				break;
			}
			index = Integer.parseInt(values.get(i));
			wrongAnswer[i] = engUpperAnswer.get(index - 1);
//			wrongAnswer.add(answer.get(index - 1));
			i++;
		}
		
//		System.out.println(wrongAnswer[0]);
		session.setAttribute("wrongEngAnswer", wrongAnswer);
		mav.addObject("engList", engList);
		mav.setViewName("book/wrongEngUpperPage");
		return mav;
	}
	@RequestMapping(value = "/wrongEngMiddlePage")
	public ModelAndView wrongEngMiddlePage(@RequestParam(name="wrong") List<String> values, HttpSession session) {
		ModelAndView mav = new ModelAndView();
//		List<String> wrongAnswer = new ArrayList<>();
		String[] wrongAnswer = new String[values.size()];
		List<EngMiddleBookVo> engList = new ArrayList<>();
		
		for(int i = 0; i < values.size(); i++) {
			engList.add(jpaEngMiddle.selectEngBookById(values.get(i)));
		}
		System.out.println("이건가 ?? " + values);
		int index = 0;
		int i = 0;
		while(true) {
			if(i > values.size() - 1) {
				break;
			}
			index = Integer.parseInt(values.get(i));
			wrongAnswer[i] = engMiddleAnswer.get(index - 1);
//			wrongAnswer.add(answer.get(index - 1));
			i++;
		}
		
//		System.out.println(wrongAnswer[0]);
		session.setAttribute("wrongEngAnswer", wrongAnswer);
		mav.addObject("engList", engList);
		mav.setViewName("book/wrongEngMiddlePage");
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
		mypageInfo.setSubjecttitle("영어(저학년)");
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

	

	@RequestMapping(value = "resultEngUpperBook")
	public ModelAndView engUpperResult(HttpServletRequest request, MypageInfo mypageInfo) {
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
			if (result.get(i).equals(engUpperAnswer.get(i))) {
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
		mypageInfo.setSubjecttitle("영어(고학년)");
		mypageInfo.setSubjectlevel("무겁게 워밍업!!");
		mypageInfo.setSubjectresult(examAnswer);
		System.out.println("마이페이지 >> " + mypageInfo);
		jpaMypage.save(mypageInfo);
		mav.addObject("examAnswer", examAnswer);
		mav.addObject("wrong", wrong);
		mav.addObject("list", result);
		mav.addObject("success", success);
		mav.addObject("fail", fail);
		mav.setViewName("book/resultEngUpper");
		return mav;
	}
	@RequestMapping(value = "resultEngMiddleBook")
	public ModelAndView engMiddleResult(HttpServletRequest request, MypageInfo mypageInfo) {
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
		System.out.println("resultmiddle : " + result);
		int success = 0;
		int fail = 0;
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i).equals(engMiddleAnswer.get(i))) {
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
		mypageInfo.setSubjecttitle("영어(중학교)");
		mypageInfo.setSubjectlevel("빡세게 워밍업!!");
		mypageInfo.setSubjectresult(examAnswer);
		System.out.println("마이페이지 >> " + mypageInfo);
		jpaMypage.save(mypageInfo);
		mav.addObject("examAnswer", examAnswer);
		mav.addObject("wrong", wrong);
		mav.addObject("list", result);
		mav.addObject("success", success);
		mav.addObject("fail", fail);
		mav.setViewName("book/resultEngMiddle");
		return mav;
	}

}

