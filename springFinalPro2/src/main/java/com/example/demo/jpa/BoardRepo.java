package com.example.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.vo.Board;
import com.example.demo.vo.EngBookVo;


public interface BoardRepo  extends JpaRepository<Board, Integer>{
	
}
