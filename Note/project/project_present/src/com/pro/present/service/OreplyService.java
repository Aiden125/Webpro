package com.pro.present.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pro.present.dao.OneBoardDao;
import com.pro.present.dto.MemberDto;

public class OreplyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto member = (MemberDto) session.getAttribute("member");
		if(member!=null) {
			String mid = member.getMid();
			String obtitle = request.getParameter("obtitle");
			String obcontent = request.getParameter("obtitle");
			String obip = request.getRemoteAddr();
			int obgroup = Integer.parseInt(request.getParameter("obgroup"));			
			int obstep = Integer.parseInt(request.getParameter("obstep"));			
			String obgetname = request.getParameter("obgetname");			
			OneBoardDao oDao = OneBoardDao.getInstance();
			int result = oDao.reply(mid, obtitle, obcontent, obip, obgroup, obstep, obgetname);
			if(result == oDao.SUCCESS) {
				request.setAttribute("oReplyResult", "?ãµÎ≥??ûë?Ñ± ?Ñ±Í≥?");
			}else {
				request.setAttribute("oReplyResult", "?ãµÎ≥??ûë?Ñ± ?ã§?å®");				
			}
		}else {
			request.setAttribute("oReplyResult", "Î°úÍ∑∏?ù∏ ?ï¥Ï£ºÏÑ∏?öî");
		}

	}

}
