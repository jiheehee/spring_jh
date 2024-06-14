package com.bs.spring.memo.model.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.bs.spring.memo.model.dao.MemoDao;
import com.bs.spring.memo.model.dto.Memo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //기본생성자 생성 어노테이션
@Service
public class MemoServiceImpl implements MemoService {
	
	private final MemoDao dao;
	private final SqlSessionTemplate session;
	
	
	@Override
	public List<Memo> selectMemoAll(Map<String, Integer> param) {
		// TODO Auto-generated method stub
		return dao.selectMemoAll(session, param);
	}
	@Override
	public int selectMemoCount() {
		// TODO Auto-generated method stub
		return dao.selectMemoCount(session);
	}
	@Override
	public int insertMemo(Memo m) {
		// TODO Auto-generated method stub
		return dao.insertMemo(session, m);
	}
	
	
	
	
	

}
