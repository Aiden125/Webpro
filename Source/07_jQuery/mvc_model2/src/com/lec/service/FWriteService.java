package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.FileBoardDao;
import com.lec.dto.FileBoardDto;

public class FWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String fname = request.getParameter("fname");
		String ftitle = request.getParameter("ftitle");
		String fcontent = request.getParameter("fcontent");
		String fip = request.getRemoteAddr();
		FileBoardDao bDao = FileBoardDao.getInstance();
		FileBoardDto dto = new FileBoardDto(0, mid, ftitle, fcontent, ffilename, frdate, fhit, fgroup, fstep, findent, fip);
		request.setAttribute("writeResult", bDao.writeBoard(dto.)(fname, ftitle, fcontent, fip));
	}
}
