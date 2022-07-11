package com.pro.present.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.present.dao.FreeBoardDao;

public class BlistViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// list.do ?? list.do?pageNum=2 ?? list.do?pageNum=10
		String pageNum = request.getParameter("pageNum");
		String word = request.getParameter("word");
		if(pageNum == null) {
			pageNum="1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 10, BLOCKSIZE = 10;
		int startRow = (currentPage-1)*PAGESIZE+1;
		int endRow = startRow + PAGESIZE -1;
		FreeBoardDao bDao = FreeBoardDao.getInstance();
		request.setAttribute("list", bDao.listBoard(word, startRow, endRow)); // κΈ?λͺ©λ‘
		int totalCnt=0;
		if(word==null) {
			totalCnt = bDao.getBoardTotalCnt();
		}else {
			totalCnt = bDao.getBoardSearchCnt(word); // ?±λ‘λ κΈ? κ°??			
		}
		int pageCnt = (int)Math.ceil((double) totalCnt/PAGESIZE); // ??΄μ§? κ°??
		int startPage = ((currentPage-1)/BLOCKSIZE) * BLOCKSIZE +1;
		int endPage = startPage + BLOCKSIZE -1;
		if(endPage > pageCnt) {
			endPage = pageCnt;
		}
		request.setAttribute("BLOCKSIZE", BLOCKSIZE); // ? ??΄μ§? κ΄?? ¨ ?­λͺ?
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageNum", currentPage);
		request.setAttribute("pageCnt", pageCnt);
	}
}
