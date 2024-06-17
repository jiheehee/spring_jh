package com.bs.spring.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bs.spring.board.model.dto.Board;

public interface BoardDao {
	
	List<Board> selectList(SqlSession session, Map<String, Integer>page);	
	Board selectBoardByNo(SqlSession session);
	int insertBoard(Board b);
	int insertBoard(SqlSession session,Board b);

}
