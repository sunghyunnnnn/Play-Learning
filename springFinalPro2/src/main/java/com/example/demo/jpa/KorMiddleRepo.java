package com.example.demo.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.vo.KorBookVo;
import com.example.demo.vo.KorMiddleBookVo;

public interface KorMiddleRepo extends JpaRepository<KorMiddleBookVo, Integer>{

	@Query(value = "select * from problemmiddlekor where kor_no =:na ", nativeQuery = true)
	public KorMiddleBookVo selectKorBookById(@Param(value="na") String kor_no);
}
