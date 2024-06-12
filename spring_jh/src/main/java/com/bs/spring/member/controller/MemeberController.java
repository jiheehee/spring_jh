package com.bs.spring.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bs.spring.member.dto.Member;
import com.bs.spring.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //의존성주입
@Controller
@RequestMapping("/member")   //이렇게 하면 자동으로 앞에"/member" 이거 붙음
public class MemeberController {
	
	private final MemberService service; //의존성 주입
	
	@PostMapping("/login.do")
	public String login(String userId, String pw) { //사용자가 입력한 userId 받아옴
		Member m=service.selectMemberById(userId); //서비스 값 Member m에 넣어줌
		System.out.println(m);
		
		
	}
	
	

}



