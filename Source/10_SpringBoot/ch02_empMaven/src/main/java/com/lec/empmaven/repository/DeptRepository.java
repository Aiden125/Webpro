package com.lec.empmaven.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.empmaven.domain.Dept;

@Mapper
public interface DeptRepository {
	public List<Dept> deptList();
}
