package com.example.demo.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.vo.KorBookVo;

public interface KorRepo extends JpaRepository<KorBookVo, Integer>{

	@Query(value = "select * from problemkor where kor_no =:na ", nativeQuery = true)
	public KorBookVo selectKorBookById(@Param(value="na") String kor_no);
}
