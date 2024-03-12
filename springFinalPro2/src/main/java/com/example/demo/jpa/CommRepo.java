package com.example.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.vo.CommVo;

public interface CommRepo extends JpaRepository<CommVo, String> {
	
	

}
