package com.pro.present.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.present.dao.OneBoardDao;

public class OdeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int obno = Integer.parseInt(request.getParameter("obno"));
		OneBoardDao oDao = OneBoardDao.getInstance();
		int result = oDao.delete(obno);
		if(result == oDao.SUCCESS) {
			request.setAttribute("deleteResult", "κΈ??­?  ?±κ³?");
		}else {
			request.setAttribute("deleteResult", "κΈ??­?  ?€?¨");			
		}
	}
}
