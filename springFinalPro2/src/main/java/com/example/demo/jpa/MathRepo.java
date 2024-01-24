package com.example.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.vo.MathBookVo;

public interface MathRepo extends JpaRepository<MathBookVo, Integer>{
	
	@Query(value = "select * from problemmath where math_no =:na ", nativeQuery = true)
	public MathBookVo selectMathBookById(@Param(value="na") String math_no);
}
