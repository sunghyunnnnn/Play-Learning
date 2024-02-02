package com.example.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.vo.Notice;

public interface NoticeRepo extends JpaRepository<Notice, Integer>{

}
