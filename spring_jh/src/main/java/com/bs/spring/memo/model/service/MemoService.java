package com.bs.spring.memo.model.service;

import java.util.List;
import java.util.Map;

import com.bs.spring.memo.model.dto.Memo;

public interface MemoService {
	
	List<Memo> selectMemoAll(Map<String,Integer>param);
	int selectMemoCount();
	int insertMemo(Memo m);
	

}
