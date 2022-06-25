package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;

public class MloginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.login(mid, mpw);
		if(result == mDao.SUCCESS) {
			HttpSession session = request.getSession();
			MemberDto member = mDao.getMemberDto(mid);
			session.setAttribute("member", member);
		}else {
			request.setAttribute("loginerroMsg", "아이디와 비밀번호를 확인하세요");
		}
	}

}
