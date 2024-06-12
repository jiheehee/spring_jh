package com.bs.spring.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.bs.spring.member.dao.MemberDao;
import com.bs.spring.member.dto.Member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
	
	private final MemberDao dao;
	private final SqlSessionTemplate session;
	
	@Override
	public Member selectMemberById(String userId) {
		// TODO Auto-generated method stub
		return dao.selectMemberById(session,userId); //session을 dao에만 넣어주는 이유는 dao가 db에 접근해서 가져오는거니까
	}
	
	
	

}
