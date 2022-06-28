package com.pro.present.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pro.present.dao.MemberDao;
import com.pro.present.dto.MemberDto;

public class MjoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String mmbti = request.getParameter("mmbti");
		String memail = request.getParameter("memail");
		String mgender = request.getParameter("mgender");
		Date mbirth = null;
		if(! request.getParameter("mbirth").equals("")) {
			mbirth = Date.valueOf(request.getParameter("mbirth") + " 00:00:00");
		}
		MemberDao mDao = MemberDao.getInstance();
		// mid 중복체크
		int result = mDao.checkId(mid);
		if(result == MemberDao.SUCCESS) { // 가입가능
			MemberDto member = new MemberDto(mid, mpw, mname, mbirth, mgender, memail, mmbti, null, null, null);
			mDao.joinMember(member);
		}
	}

}
