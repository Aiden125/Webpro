package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.FileBoardDao;

public class FlistViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// list.do 또는 list.do?pageNum=2 또는 list.do?pageNum=10
				String pageNum = request.getParameter("pageNum");
				if(pageNum == null) {
					pageNum="1";
				}
				int currentPage = Integer.parseInt(pageNum);
				final int PAGESIZE = 10, BLOCKSIZE = 10;
				int startRow = (currentPage-1)*PAGESIZE+1;
				int endRow = startRow + PAGESIZE -1;
				FileBoardDao fDao = FileBoardDao.getInstance();
				request.setAttribute("list", fDao.boardList(startRow, endRow)); // 글목록
				int totalCnt = fDao.boardTotCnt(); // 등록된 글 갯수
				int pageCnt = (int)Math.ceil((double) totalCnt/PAGESIZE); // 페이지 갯수
				int startPage = ((currentPage-1)/BLOCKSIZE) * BLOCKSIZE +1;
				int endPage = startPage + BLOCKSIZE -1;
				if(endPage > pageCnt) {
					endPage = pageCnt;
				}
				request.setAttribute("BLOCKSIZE", BLOCKSIZE); // ★ 페이지 관련 항목
				request.setAttribute("startPage", startPage);
				request.setAttribute("endPage", endPage);
				request.setAttribute("pageNum", currentPage);
				request.setAttribute("pageCnt", pageCnt);
			}
		}