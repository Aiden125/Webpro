package com.lec.ch17.bservice;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lec.ch17.dao.BoardDao;
import com.lec.ch17.dto.Board;
import com.lec.ch17.util.Paging;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public List<Board> boardList(String pageNum) {
		Paging paging = new Paging(boardDao.totCnt(), pageNum, 10, 5);
		Board board = new Board();
		board.setStartRow(paging.getStartRow());
		board.setEndRow(paging.getEndRow());
		return boardDao.boardList(board);
	}
	
	@Override
	public int write(Board board, HttpServletRequest request) {
		board.setBip(request.getRemoteAddr());
		return boardDao.write(board);
	}


	@Override
	public int totCnt() {
		return boardDao.totCnt();
	}



}
