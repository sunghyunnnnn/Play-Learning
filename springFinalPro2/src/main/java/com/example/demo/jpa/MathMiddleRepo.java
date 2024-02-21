package com.example.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.vo.MathBookVo;
import com.example.demo.vo.MathMiddleBookVo;
import com.example.demo.vo.MathUpperBookVo;

public interface MathMiddleRepo extends JpaRepository<MathMiddleBookVo, Integer>{
	
	@Query(value = "select * from problemmiddlemath where math_no =:na ", nativeQuery = true)
	public MathMiddleBookVo selectMathBookById(@Param(value="na") String math_no);
}
