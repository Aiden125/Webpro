package com.lec.ch17.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch17.dto.Board;

@Mapper
public interface BoardDao {
	public List<Board> boardList(Board board);
	public int write(Board board);
	public int totCnt();
}
