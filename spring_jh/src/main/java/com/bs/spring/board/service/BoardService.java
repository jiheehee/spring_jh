package com.bs.spring.board.service;

import java.util.List;
import java.util.Map;

import com.bs.spring.board.model.dto.Board;

public interface BoardService {
	
	List<Board> selectList(Map<String,Integer>page);
	Board selectBoardByNo(int boardNo);
	int insertBoard(Board b);
	int selectBoardCount();  //페이징처리
	
}
