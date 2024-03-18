package com.example.demo.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.vo.CommVo;
import com.example.demo.vo.EngMiddleBookVo;

public interface CommRepo extends JpaRepository <CommVo, Integer> {
	@Query(value = "SELECT * FROM comm WHERE num=:na", nativeQuery = true)
	public List<CommVo> selectbynum(@Param(value="na") int num);
	
	
}
