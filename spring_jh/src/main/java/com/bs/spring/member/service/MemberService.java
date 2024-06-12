package com.bs.spring.member.service;

import com.bs.spring.member.dto.Member;

public interface MemberService {
	
	Member selectMemberById(String userId);
	

}
