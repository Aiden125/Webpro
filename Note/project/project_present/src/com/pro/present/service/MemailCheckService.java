package com.pro.present.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.present.dao.MemberDao;

public class MemailCheckService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String memail = request.getParameter("memail");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.checkEmail(memail);
		if(result == MemberDao.FAIL) {
			request.setAttribute("emailCheckResult", "ì¤‘ë³µ?œ ?´ë©”ì¼?…?‹ˆ?‹¤");
		}else{
			request.setAttribute("emailCheckResult", "?‚¬?š©ê°??Š¥?•œ ?´ë©”ì¼?…?‹ˆ?‹¤");
		}
	}
}
