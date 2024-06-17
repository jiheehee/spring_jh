package com.bs.spring.board.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.bs.spring.board.model.dao.BoardDao;
import com.bs.spring.board.model.dto.Board;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
	
	private final BoardDao dao;
	private final SqlSession session;
	@Override
	public List<Board> selectList(Map<String, Integer> page) {
		// TODO Auto-generated method stub
		return dao.selectList(session,page);
	}
	@Override
	public Board selectBoardByNo(int boardNo) {
		// TODO Auto-generated method stub
		return dao.selectBoardByNo(session,boardNo);
	}
	@Override
	public int insertBoard(Board b) {
		// TODO Auto-generated method stub
		return dao.insertBoard(session,b);
	}
	@Override
	public int selectBoardCount() {
		// TODO Auto-generated method stub
		return dao.selectBoardCount(session);
	}


	
	
	
	

}
