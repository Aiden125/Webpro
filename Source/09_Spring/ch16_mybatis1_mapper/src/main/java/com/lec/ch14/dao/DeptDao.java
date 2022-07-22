package com.lec.ch14.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch14.dto.Dept;

@Mapper // 이 인터페이스는 mapper랑 연결된 인터페이스야
public interface DeptDao {
	public List<Dept> deptList();
}
