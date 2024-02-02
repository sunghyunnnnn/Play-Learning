package com.example.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.vo.Board;


public interface BoardRepo  extends JpaRepository<Board, Integer>{

}
