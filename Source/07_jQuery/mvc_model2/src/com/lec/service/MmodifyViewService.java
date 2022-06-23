package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.FileBoardDao;

public class MmodifyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fid = Integer.parseInt(request.getParameter("fid"));
		FileBoardDao fDao = FileBoardDao.getInstance();
		request.setAttribute("modify_view", fDao.getFile(fid));
	}

}
