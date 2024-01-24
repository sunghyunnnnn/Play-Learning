package com.example.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.vo.EngBookVo;
import com.example.demo.vo.MathBookVo;

public interface EngRepo extends JpaRepository<EngBookVo, Integer>{
	
	@Query(value = "select * from problemeng where eng_no =:na ", nativeQuery = true)
	public EngBookVo selectEngBookById(@Param(value="na") String eng_no);
}
