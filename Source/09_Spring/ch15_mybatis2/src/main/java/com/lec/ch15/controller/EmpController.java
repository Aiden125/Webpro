package com.lec.ch15.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch15.dto.Emp;
import com.lec.ch15.service.EmpService;
import com.lec.ch15.util.Paging;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	
	// 기본 리스트
	@RequestMapping(value="empList" , method = RequestMethod.GET)
	public String empList(String pageNum, Model model) {
		model.addAttribute("empList", empService.empList(pageNum));
		model.addAttribute("paging", new Paging(empService.totCnt(), pageNum, 10, 5));
		return "empList";
	}
	
	// 더미 넣기
	@RequestMapping(value="dummyDataInsert", method = RequestMethod.GET)
	public String dummyDataInsert() {
		empService.dummyDataInsert50();
		return "redirect:empList.do";
	}
	
	// 부서명 보이는 리스트
	@RequestMapping(value="empDeptList", method = {RequestMethod.GET, RequestMethod.POST })
	public String empDeptList(String pageNum, Model model) {
		//empDeptList.do , empDeptList.do? pageNum=2
		model.addAttribute("empList", empService.empDeptList(pageNum));
		model.addAttribute("paging", new Paging(empService.totCnt(), pageNum, 10, 5));
		return "empDeptList";
	}
	
	// 상세보기
	@RequestMapping(value="detail", method = RequestMethod.GET)
	public String detail(int empno, Model model) {
		model.addAttribute("empDto", empService.detail(empno));
		return "detail";
	}
	
	// 수정상세보기
	@RequestMapping(value="updateView", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateView(int empno, Model model) {
		model.addAttribute("empDto", empService.detail(empno));
		return "update";
	}
	
	// 수정하기
	@RequestMapping(value="update", method = RequestMethod.POST)
	public String update(Emp emp, String tempHiredate, Model model) {
		emp.setHiredate(Timestamp.valueOf(tempHiredate + " 00:00:00"));
		try {
			model.addAttribute("updateResult", empService.update(emp));			
		}catch(Exception e) {
			model.addAttribute("updateResult", "필드 값이 너무 깁니다");
			return "forward:updateView.do"; // 에러난 경우 수정보기로 다시보내기
		}
		return "forward:empDeptList.do";
	}
	
	// 삭제하기
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int empno, Model model) {
		model.addAttribute("deleteResult", empService.delete(empno));
		return "forward:empDeptList.do";
	}
	
	// 작성 상세보기
	@RequestMapping(value = "writeView", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeView(Model model) {
		model.addAttribute("managerList", empService.managerList());
		model.addAttribute("deptList", empService.deptList());
		return "write";
	}
	
	// 중복검사
	@RequestMapping(value = "confirmNo", method = RequestMethod.GET)
	public String confirmNo(int empno, Model model) {
		if(empService.detail(empno) == null) { // null인 경우는 중복되는게 없는 경우
			model.addAttribute("msg", "사용 가능한 사번입니다");
		}else {
			model.addAttribute("msg", "중복된 사번입니다");
		}
		return "forward:writeView.do";
	}
}
