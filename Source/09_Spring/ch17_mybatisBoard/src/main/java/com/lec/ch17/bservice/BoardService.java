package com.lec.ch17.bservice;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.lec.ch17.dto.Board;

public interface BoardService {
	public List<Board> boardList(String pageNum);
	public int totCnt();
	public int write(Board board, HttpServletRequest request);
	
}
