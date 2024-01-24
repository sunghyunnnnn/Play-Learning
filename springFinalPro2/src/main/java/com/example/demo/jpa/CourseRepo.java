package com.example.demo.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.vo.CourseVo;

public interface CourseRepo extends JpaRepository<CourseVo, String>{
	
//	반환형은 기본적으로 객체형이다
	
	
//	사용자 정의 쿼리 작성
	@Query(value = "select * from course where title like %:title%", nativeQuery = true)
	public List<CourseVo> selectCourseTitle(@Param(value = "title") String title);
	
}
