package com.lec.empmaven.service;

import java.util.List;

import com.lec.empmaven.domain.Dept;
import com.lec.empmaven.domain.Emp;

public interface EmpService {
	public List<Dept> deptList();
	public List<Emp> empList(Emp searchEmp);
}
