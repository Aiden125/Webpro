package com.lec.ch15.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch15.dto.Emp;

@Mapper
public interface EmpDao {
	// Emp.xml에 잇는 id랑 똑같이 만들어야 class를 다시 안만들어도 된다
	// Emp.xml과 맞추면서 파라미터 타입이 없으면 매개변수 x
	public List<Emp> empList(Emp emp);
	public List<Emp> empDeptList(Emp emp);
	public int totCnt();
	public Emp detail(int empno);
	public List<Emp> managerList();
	public int insert(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
	
}
