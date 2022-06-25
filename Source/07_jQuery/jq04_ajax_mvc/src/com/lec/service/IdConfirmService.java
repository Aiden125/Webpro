package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;

public class IdConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.checkId(mId);
		if(result == MemberDao.FAIL) {
			request.setAttribute("idConfirmResult", "사용가능한 ID를 입력하세요");
		}else{
			request.setAttribute("idConfirmResult", "사용가능한 ID입니다");
		}
	}

}
