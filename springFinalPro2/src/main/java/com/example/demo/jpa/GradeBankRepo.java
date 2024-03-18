package com.example.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.vo.GradeBankVo;

public interface GradeBankRepo extends JpaRepository<GradeBankVo, Integer>{
	
	@Query(value = "select sum(premoney) + sum(genmoney) from gradebank")
	public int selectTotalMoney();
	@Query(value = "select sum(premoney) from gradebank")
	public int selectPreMoney();
	@Query(value = "select sum(genmoney) from gradebank")
	public int selectGenMoney();
}
