package com.pro.present.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.present.dao.MemberDao;

public class MnameCheckService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mname = request.getParameter("mname");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.checkName(mname);
		if(result == MemberDao.FAIL) {
			request.setAttribute("nameCheckResult", "ì¤‘ë³µ?œ ?‹‰?„¤?„?…?‹ˆ?‹¤");
		}else{
			request.setAttribute("nameCheckResult", "?‚¬?š©ê°??Š¥?•œ ?‹‰?„¤?„?…?‹ˆ?‹¤");
		}
	}
}
