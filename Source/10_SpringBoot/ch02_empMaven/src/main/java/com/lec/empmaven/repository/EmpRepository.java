package com.lec.empmaven.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.empmaven.domain.Emp;

@Mapper
public interface EmpRepository {
	public List<Emp> empList(Emp searchEmp);
}
