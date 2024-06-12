package com.bs.spring.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bs.spring.member.dto.Member;

import lombok.RequiredArgsConstructor;

@Repository
public class MemberDaoImpl implements MemberDao {
	
//	private final MemberDao dao; //의존성 주입
	

	@Override
	public Member selectMemberById(SqlSessionTemplate session, String userId) {
		return session.selectOne("member.selectMemberById",userId);
	}
	
	

}
