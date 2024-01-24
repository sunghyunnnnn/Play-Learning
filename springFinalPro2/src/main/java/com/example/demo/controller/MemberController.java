package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.jpa.JpaMemberRepository;
import com.example.demo.vo.Member;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
// adassadssdd
   @Autowired
   JpaMemberRepository jpaMember;
   
   
   
   @RequestMapping(value="signinControl")
   public ModelAndView signin(Member member) {
	   String input_pw = member.getPw();
	      System.out.println("사용자 입력 비번="+input_pw);
	   /*
      String input_name = member.getName();
      System.out.println("사용자 입력 이름="+input_name);
      String input_birth = member.getBirth();
      System.out.println("사용자 입력 생년월일="+input_birth);
      String input_id = member.getId();
      System.out.println("사용자 입력 아이디="+input_id);
      String input_email = member.getEmail();
      System.out.println("사용자 입력 이메일="+input_email);
      String input_address = member.getAddress();
      System.out.println("사용자 입력 주소="+input_address);
      String input_phonenum = member.getPhonenum();
      System.out.println("사용자 입력 전화번호="+input_phonenum);
      */
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
      String encode_pw = encoder.encode(input_pw);
      System.out.println("암호화 비번="+encode_pw);
      member.setPw(encode_pw);
      
      jpaMember.save(member);
      
      ModelAndView mav = new ModelAndView();
      mav.setViewName("index");
      return mav;
   }
   
   
   
   @RequestMapping(value="loginControl")
   public ModelAndView login(Member mem, HttpSession session) {
      String inputId = mem.getId();
      boolean pwMatch = false;
      Member dbMember = null;
      System.out.println(inputId);
      
      try {
         dbMember = jpaMember.getById(inputId);
         String dbPw = dbMember.getPw();
         String inputPW = mem.getPw();
         
         BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
         
         pwMatch = encoder.matches(inputPW, dbPw);
         System.out.println(pwMatch);
      } catch (Exception e) {
         e.printStackTrace();
            }
         ModelAndView mav = new ModelAndView();
         
         if(pwMatch == true) {
            session.setAttribute("login_number", dbMember);
            mav.addObject("user", mem.getId());
            mav.addObject("pwMatch", pwMatch);
            mav.setViewName("index");
            
         }else {
            System.out.println("아이디틀림");
            mav.addObject("loginError", "아이디 혹은 비밀번호가 일치 하지 않습니다.");
            mav.addObject("pwMatch", pwMatch);
            mav.setViewName("login");
         }
         return mav;
      }

}