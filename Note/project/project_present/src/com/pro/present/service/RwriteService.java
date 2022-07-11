package com.pro.present.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.pro.present.dao.ReplyDao;
import com.pro.present.dto.MemberDto;

public class RwriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto member = (MemberDto) session.getAttribute("member");
		
		if(member != null) {
			String mid = member.getMid();
			int bno = Integer.parseInt(request.getParameter("bno"));
			String rcontent = request.getParameter("rcontent");
			String rip = request.getRemoteAddr();
			ReplyDao rDao = ReplyDao.getInstance();
			int result = rDao.writeReply(mid, bno, rcontent, rip);
			if(result == rDao.SUCCESS) {
				request.setAttribute("replyResult", "?åìÍ∏??ûë?Ñ± ?Ñ±Í≥?");			
			}else {
				request.setAttribute("replyResult", "?åìÍ∏??ûë?Ñ± ?ã§?å®");						
			}
		}else {
			request.setAttribute("replyResult", "Î°úÍ∑∏?ù∏ ?ï¥Ï£ºÏÑ∏?öî");
		}
	}
}
