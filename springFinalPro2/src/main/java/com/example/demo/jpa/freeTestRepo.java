package com.example.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.vo.FreeBookVo;

public interface freeTestRepo extends JpaRepository<FreeBookVo, Integer>{

}
