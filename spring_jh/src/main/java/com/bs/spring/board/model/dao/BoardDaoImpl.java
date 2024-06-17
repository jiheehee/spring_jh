package com.bs.spring.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bs.spring.board.model.dto.Board;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Override
	public List<Board> selectList(SqlSession session, Map<String, Integer> page) {
		// TODO Auto-generated method stub
		return session.selectList("board.boardlist",null,
				new Rowbounds((page.get("cPage")-1)));
	}

	@Override
	public Board selectBoardByNo(SqlSession session) {
		return session.select("board.selectboard");
	}

	@Override
	public int insertBoard(Board b) {
		// TODO Auto-generated method stub
		return session.selectOne("board.boardCount");
	}

	@Override
	public int insertBoard(SqlSession session, Board b) {
		// TODO Auto-generated method stub
		return session.update("board.boardUpdate", boardNo);
	}


	
	
	

}
