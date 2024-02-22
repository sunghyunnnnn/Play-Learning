package com.example.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.vo.EngBookVo;
import com.example.demo.vo.EngMiddleBookVo;
import com.example.demo.vo.EngUpperBookVo;
import com.example.demo.vo.MathBookVo;

public interface EngMiddleRepo extends JpaRepository<EngMiddleBookVo, Integer>{
	
	@Query(value = "select * from problemmiddleeng where eng_no =:na ", nativeQuery = true)
	public EngMiddleBookVo selectEngBookById(@Param(value="na") String eng_no);
}
