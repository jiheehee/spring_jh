package com.bs.spring.demo.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.bs.spring.demo.model.dao.DemoDao;
import com.bs.spring.demo.model.dto.Demo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DemoServiceImpl implements DemoService {
	
	private final DemoDao dao;	
	private final SqlSessionTemplate session;	
	
//	@Autowired
//	public DemoServiceImpl(DemoDao demo) {
//		this.dao=dao;
//	}

	@Override
	public int insertDemo(Demo d) {
		
		return dao.insertDemo(session, d);
		//close이런거 안해도 됨. spring이 알아서 해줌!
		
	}

	@Override	
	public List<Demo> selectDemoList(Map<String, Integer> param) {
		return dao.selectDemo(session,param);
	}
	
	@Override
	public int updateDemo(Demo d) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Demo selectByNo(int no) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
