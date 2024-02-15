package com.example.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.vo.MathBookVo;
import com.example.demo.vo.MathUpperBookVo;

public interface MathUpperRepo extends JpaRepository<MathUpperBookVo, Integer>{
	
	@Query(value = "select * from problemuppermath where math_no =:na ", nativeQuery = true)
	public MathUpperBookVo selectMathBookById(@Param(value="na") String math_no);
}
