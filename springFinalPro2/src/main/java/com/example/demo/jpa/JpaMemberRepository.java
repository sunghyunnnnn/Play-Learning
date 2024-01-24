package com.example.demo.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.Member;

@Repository
public interface JpaMemberRepository extends JpaRepository<Member, String>{

@Query(value = "select id from member where phonenum = :na", nativeQuery = true)
public String selectMemberId1(@Param(value = "na") String phonenum);
@Query(value = "select id from member where name = :na", nativeQuery = true)
public String selectMemberId2(@Param(value = "na") String name);
@Query(value = "select id from member where email = :na", nativeQuery = true)
public String selectMemberId3(@Param(value = "na") String email);
@Query(value = "select id from member")
public List<String> selectMemberId();
}