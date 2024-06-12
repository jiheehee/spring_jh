package com.bs.spring.member.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.bs.spring.member.dto.Member;

public interface MemberDao {
	
	Member selectMemberById(SqlSessionTemplate session,String userId);

}
